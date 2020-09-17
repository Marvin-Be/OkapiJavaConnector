package com.okapiorbits.platform;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

/**
 * This class provides helper methods to send and retrieve information to and from the OKAPI platform.
 * @author Christopher Kebschull
 * @author Niels Perdijk
 * @version v2020-09
 */
public class OkapiConnector {

	private final String username;
	private final String password;
	private final String baseUrl;
	
	int responseCode;

	/**
	 * Handles the error messages handed over from the OKAPI and Auth0 end points.
	 * @author Niels Perdijk
	 */
	public static class OkapiPlatformException extends Exception {
		private static final long serialVersionUID = 2526489312574632854L;

		public OkapiPlatformException(String message) {
			super(message);
		}
	}

	/**
	 * Collects the credentials used to retrieve the authentication token and uses https://platform.okapiorbits.com/api/
	 * to communicate to the OKAPI platform.
	 * @param username - your OKAPI username
	 * @param password - your OKAPI platform password
	 */
	public OkapiConnector(String username, String password) {
		this(username,password,"https://platform.okapiorbits.com/api/");
	}

	/**
	 * Collects the credentials used to retrieve the authentication token and the URL used to communicate with the platform.
	 * @param username - your OKAPI username
	 * @param password - your OKAPI platform password
	 * @param baseUrl - the URL pointing to the OKAPI backend
	 */
	public OkapiConnector(String username, String password, String baseUrl) {
		this.username = username;
		this.password = password;
		this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
	}

	/**
	 * Connect to the Auth0 identity provider and retrieve an access token needed to communicate with the OKAPI end points.
	 * @return an access token as {@link String}
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String getToken() throws OkapiPlatformException {
		String accessToken;
		JSONObject requestTokenPayloadJson = new JSONObject();
		requestTokenPayloadJson.put("grant_type", "password");
		requestTokenPayloadJson.put("username", this.username);
		requestTokenPayloadJson.put("password", this.password);
		requestTokenPayloadJson.put("audience", "https://api.okapiorbits.space/picard");
		requestTokenPayloadJson.put("scope", "('')");
		requestTokenPayloadJson.put("client_id", "jrk0ZTrTuApxUstXcXdu9r71IX5IeKD3");
		String requestTokenPayloadString = requestTokenPayloadJson.toString();

		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://okapi-development.eu.auth0.com/oauth/token/"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(requestTokenPayloadString))
				.build();

		HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			JSONObject error = new JSONObject();
			error.put("message", e.getMessage());
			error.put("status", "FATAL");
			System.out.println(error.toString());
			return error.toString();
		}

		this.responseCode = response.statusCode();
		if (responseCode >= 300) {
			throw new OkapiPlatformException("HTTPError: " + response.statusCode() + "; Message: " + response.body());
		}
		JSONObject responseJson = new JSONObject(response.body());
		accessToken = responseJson.getString("access_token");
		return (accessToken);
	}

	/**
	 * Send a service execution request to the platform and retrieve the response. The response is parsed for the 'request_id' key.
	 * The key is returned
	 * @param endpoint - the request (POST) end point from the OKAPI interface definition
	 * @param bodyString - a JSON formatted request body containing information like an initial orbit or ground location
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @return a request id from the platform
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String sendAndGetRequestId(String endpoint, String bodyString, String accessToken) throws OkapiPlatformException {
		String response = send(endpoint,bodyString,accessToken);
		JSONObject responseJson = new JSONObject(response);
		return responseJson.getString("request_id");
	}

	/**
	 * Send a service execution request to the platform and retrieve the response as string.
	 * @param endpoint - the request (POST) end point from the OKAPI interface definition, .e.g '/satellites'
	 * @param bodyString - a JSON formatted request body containing information like an initial orbit or ground location
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @return a JSON from the platform or "{}" as {@link String}
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String send(String endpoint, String bodyString, String accessToken) throws OkapiPlatformException {

		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.baseUrl + (endpoint.startsWith("/") ? endpoint.substring(1) : endpoint)))
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + accessToken)
				.POST(HttpRequest.BodyPublishers.ofString(bodyString))
				.build();

		HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			JSONObject error = new JSONObject();
			error.put("message", e.getMessage());
			error.put("status", "FATAL");
			System.out.println(error.toString());
			return error.toString();
		}

		this.responseCode = response.statusCode();
		if (responseCode >= 300) {
			throw new OkapiPlatformException("HTTPError: " + response.statusCode() + "; Message: " + response.body());
		}

		return (response.body());
	}

	/**
	 * Send a service update request to the platform and retrieve the response as string.
	 * @param endpoint - the request (UPDATE) end point from the OKAPI interface definition, .e.g '/satellites/$id'
	 * @param bodyString - a JSON formatted request body containing information like an initial orbit or ground location
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @return a JSON from the platform or "{}" as {@link String}
	 */
	public String update(String endpoint, String bodyString, String accessToken) throws OkapiPlatformException {

		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.baseUrl + (endpoint.startsWith("/") ? endpoint.substring(1) : endpoint)))
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + accessToken)
				.PUT(HttpRequest.BodyPublishers.ofString(bodyString))
				.build();

		HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			JSONObject error = new JSONObject();
			error.put("message", e.getMessage());
			error.put("status", "FATAL");
			System.out.println(error.toString());
			return error.toString();
		}
		this.responseCode = response.statusCode();
		if (responseCode >= 300) {
			throw new OkapiPlatformException("HTTPError: " + response.statusCode() + "; Message: " + response.body());
		}

		return (response.body());
	}

	/**
	 * Waits 15 seconds and retrieves the results.
	 * @param endpoint - the request (GET) end point from the OKAPI interface definition, .e.g 'propagate-orbit/sgp4/results/$id/omm'
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @return A JSON formatted response from the platform as {@link String}
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String waitForProcessingAndGetValues(String endpoint, String accessToken) throws OkapiPlatformException {
		return this.waitForProcessingAndGetValues(endpoint,accessToken,15);
	}

	/**
	 * Will wait for the backend and retrieves the results.
	 * @param endpoint - the request (GET) end point from the OKAPI interface definition, .e.g 'propagate-orbit/sgp4/results/$id/omm'
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @param timeout - time frame in seconds in which to poll the OKAPI platform for the results
	 * @return A JSON formatted response from the platform as {@link String}
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String waitForProcessingAndGetValues(String endpoint, String accessToken, int timeout) throws OkapiPlatformException {
		String resultNeptuneSimple;
		int requestCounter = 0;
		do {
			resultNeptuneSimple = this.getValues(endpoint, accessToken);
			requestCounter++;
			if (responseCode != 202) break;
			if (requestCounter == timeout) throw new OkapiPlatformException("No values retrieved from the backend within " + timeout + " seconds.");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(true);
		return resultNeptuneSimple;
	}
	
	/**
	 * Retrieves the values related to a given request encapsulated in the URL from the OKAPI platform.
	 * @param endpoint - the request (GET) end point from the OKAPI interface definition, .e.g 'propagate-orbit/sgp4/results/$id/omm'
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @return A JSON formatted response from the platform as {@link String}
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String getValues(String endpoint, String accessToken) throws OkapiPlatformException {

		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.baseUrl + (endpoint.startsWith("/") ? endpoint.substring(1) : endpoint)))
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + accessToken)
				.GET()
				.build();

		HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			JSONObject error = new JSONObject();
			error.put("message", e.getMessage());
			error.put("status", "FATAL");
			System.out.println(error.toString());
			return error.toString();
		}
		this.responseCode = response.statusCode();
		if (responseCode >= 300) {
			throw new OkapiPlatformException("HTTPError: " + response.statusCode() + "; Message: " + response.body());
		}
		return (response.body());
	}

	/**
	 * Send a remove request to the platform and retrieve the response as string.
	 * @param endpoint - the request (DELETE) end point from the OKAPI interface definition, .e.g '/satellites/$id'
	 * @param accessToken - the access token enabling the access to the OKAPI services
	 * @return A JSON formatted response from the platform as {@link String}
	 * @throws OkapiPlatformException Raised when the web status is different than 202/200 or a timeout occurs.
	 */
	public String deleteRequest(String endpoint, String accessToken) throws OkapiPlatformException {

		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.baseUrl + (endpoint.startsWith("/") ? endpoint.substring(1) : endpoint)))
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + accessToken)
				.DELETE()
				.build();

		HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			JSONObject error = new JSONObject();
			error.put("message", e.getMessage());
			error.put("status", "FATAL");
			System.out.println(error.toString());
			return error.toString();
		}
		this.responseCode = response.statusCode();
		if (responseCode >= 300) {
			throw new OkapiPlatformException("HTTPError: " + response.statusCode() + "; Message: " + response.body());
		}
		return (response.body());
	}
}