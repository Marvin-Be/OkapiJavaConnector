
package com.okapiorbits.platform.science.jobs.json;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Satellite
 * <p>
 * A satellite. It may define exactly one satellite or may be the representative of a satellite class, i.e. more than one satellite of similar design.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "satellite_id",
    "name",
    "norad_ids",
    "area",
    "mass",
    "thrust_uncertainty",
    "thrust_pointing_uncertainty",
    "thrust_output",
    "propulsion_type",
    "accepted_collision_probability",
    "accepted_minimum_distance",
    "use_ai_risk_prediction",
    "space_track_status",
    "space_track_status_other",
    "space_track_company_name",
    "space_track_poc_name",
    "space_track_poc_address",
    "space_track_login",
    "active",
    "maneuver_strategy"
})
public class Satellite {

    /**
     * Uuid
     * <p>
     * A Universally-Unique IDentifier, as used by OKAPI
     * (Required)
     * 
     */
    @JsonProperty("satellite_id")
    @JsonPropertyDescription("A Universally-Unique IDentifier, as used by OKAPI")
    private String satelliteId;
    /**
     * Name of this satellite or the class of satellites this satellite functions as representative
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of this satellite or the class of satellites this satellite functions as representative")
    private String name;
    /**
     * NORAD IDs of satellites this satellite definition stands for. If only one satellite is defined, this array contains the NORAD ID of that satellite.
     * (Required)
     * 
     */
    @JsonProperty("norad_ids")
    @JsonPropertyDescription("NORAD IDs of satellites this satellite definition stands for. If only one satellite is defined, this array contains the NORAD ID of that satellite.")
    private List<Integer> noradIds = new ArrayList<Integer>();
    /**
     * The satellite's area or cross section, in m^2
     * 
     */
    @JsonProperty("area")
    @JsonPropertyDescription("The satellite's area or cross section, in m^2")
    private Double area = 1.0D;
    /**
     * in kg
     * 
     */
    @JsonProperty("mass")
    @JsonPropertyDescription("in kg")
    private Double mass = 1.0D;
    /**
     * Thrust uncertainty, in N (one sigma)
     * 
     */
    @JsonProperty("thrust_uncertainty")
    @JsonPropertyDescription("Thrust uncertainty, in N (one sigma)")
    private Double thrustUncertainty = 0.0D;
    /**
     * Uncertainty in pointing the thrust, in degrees (one sigma)
     * 
     */
    @JsonProperty("thrust_pointing_uncertainty")
    @JsonPropertyDescription("Uncertainty in pointing the thrust, in degrees (one sigma)")
    private Double thrustPointingUncertainty = 0.0D;
    /**
     * Thrust output, in N
     * 
     */
    @JsonProperty("thrust_output")
    @JsonPropertyDescription("Thrust output, in N")
    private Double thrustOutput = 0.0D;
    @JsonProperty("propulsion_type")
    private Satellite.PropulsionType propulsionType = Satellite.PropulsionType.fromValue("continuous");
    /**
     * Accepted collision probability
     * 
     */
    @JsonProperty("accepted_collision_probability")
    @JsonPropertyDescription("Accepted collision probability")
    private Double acceptedCollisionProbability = 1.0E-4D;
    /**
     * Accepted minimum distance, in km
     * 
     */
    @JsonProperty("accepted_minimum_distance")
    @JsonPropertyDescription("Accepted minimum distance, in km")
    private Double acceptedMinimumDistance = 50.0D;
    /**
     * Use OKAPI AI for risk prediction
     * 
     */
    @JsonProperty("use_ai_risk_prediction")
    @JsonPropertyDescription("Use OKAPI AI for risk prediction")
    private Boolean useAiRiskPrediction = false;
    /**
     * Please state your current relationship with SpaceTrack / 18 SPCS concerning this satellite
     * (Required)
     * 
     */
    @JsonProperty("space_track_status")
    @JsonPropertyDescription("Please state your current relationship with SpaceTrack / 18 SPCS concerning this satellite")
    private Satellite.SpaceTrackStatus spaceTrackStatus;
    /**
     * If you select "other" for "space_track_status", describe your current relationship here
     * 
     */
    @JsonProperty("space_track_status_other")
    @JsonPropertyDescription("If you select \"other\" for \"space_track_status\", describe your current relationship here")
    private String spaceTrackStatusOther;
    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the company name used at SpaceTrack here. By default, this is the company name you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_company_name")
    @JsonPropertyDescription("If you select \"sharing_agreement_signed\", \"satellite_registered\" or \"space_track_account_exists\" for \"space_track_status\", state the company name used at SpaceTrack here. By default, this is the company name you are using at OKAPI.")
    private String spaceTrackCompanyName;
    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the Point-of-Contact name used at SpaceTrack here. By default, this is the address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_poc_name")
    @JsonPropertyDescription("If you select \"sharing_agreement_signed\", \"satellite_registered\" or \"space_track_account_exists\" for \"space_track_status\", state the Point-of-Contact name used at SpaceTrack here. By default, this is the address you are using at OKAPI.")
    private String spaceTrackPocName;
    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the Point-of-Contact address used at SpaceTrack here. By default, this is the address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_poc_address")
    @JsonPropertyDescription("If you select \"sharing_agreement_signed\", \"satellite_registered\" or \"space_track_account_exists\" for \"space_track_status\", state the Point-of-Contact address used at SpaceTrack here. By default, this is the address you are using at OKAPI.")
    private String spaceTrackPocAddress;
    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the login used at SpaceTrack here. By default, this is the mail address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_login")
    @JsonPropertyDescription("If you select \"sharing_agreement_signed\", \"satellite_registered\" or \"space_track_account_exists\" for \"space_track_status\", state the login used at SpaceTrack here. By default, this is the mail address you are using at OKAPI.")
    private String spaceTrackLogin;
    /**
     * Active status of this satellite. Indicates if screening is currently activated for this satellite definition. Is set automatically by OKAPI. Immutable by clients.
     * 
     */
    @JsonProperty("active")
    @JsonPropertyDescription("Active status of this satellite. Indicates if screening is currently activated for this satellite definition. Is set automatically by OKAPI. Immutable by clients.")
    private Boolean active = false;
    /**
     * Preferred collision avoidance maneuver strategy for this satellite
     * 
     */
    @JsonProperty("maneuver_strategy")
    @JsonPropertyDescription("Preferred collision avoidance maneuver strategy for this satellite")
    private Satellite.ManeuverStrategy maneuverStrategy = Satellite.ManeuverStrategy.fromValue("short_term_and_long_term");

    /**
     * Uuid
     * <p>
     * A Universally-Unique IDentifier, as used by OKAPI
     * (Required)
     * 
     */
    @JsonProperty("satellite_id")
    public String getSatelliteId() {
        return satelliteId;
    }

    /**
     * Uuid
     * <p>
     * A Universally-Unique IDentifier, as used by OKAPI
     * (Required)
     * 
     */
    @JsonProperty("satellite_id")
    public void setSatelliteId(String satelliteId) {
        this.satelliteId = satelliteId;
    }

    /**
     * Name of this satellite or the class of satellites this satellite functions as representative
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of this satellite or the class of satellites this satellite functions as representative
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * NORAD IDs of satellites this satellite definition stands for. If only one satellite is defined, this array contains the NORAD ID of that satellite.
     * (Required)
     * 
     */
    @JsonProperty("norad_ids")
    public List<Integer> getNoradIds() {
        return noradIds;
    }

    /**
     * NORAD IDs of satellites this satellite definition stands for. If only one satellite is defined, this array contains the NORAD ID of that satellite.
     * (Required)
     * 
     */
    @JsonProperty("norad_ids")
    public void setNoradIds(List<Integer> noradIds) {
        this.noradIds = noradIds;
    }

    /**
     * The satellite's area or cross section, in m^2
     * 
     */
    @JsonProperty("area")
    public Double getArea() {
        return area;
    }

    /**
     * The satellite's area or cross section, in m^2
     * 
     */
    @JsonProperty("area")
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * in kg
     * 
     */
    @JsonProperty("mass")
    public Double getMass() {
        return mass;
    }

    /**
     * in kg
     * 
     */
    @JsonProperty("mass")
    public void setMass(Double mass) {
        this.mass = mass;
    }

    /**
     * Thrust uncertainty, in N (one sigma)
     * 
     */
    @JsonProperty("thrust_uncertainty")
    public Double getThrustUncertainty() {
        return thrustUncertainty;
    }

    /**
     * Thrust uncertainty, in N (one sigma)
     * 
     */
    @JsonProperty("thrust_uncertainty")
    public void setThrustUncertainty(Double thrustUncertainty) {
        this.thrustUncertainty = thrustUncertainty;
    }

    /**
     * Uncertainty in pointing the thrust, in degrees (one sigma)
     * 
     */
    @JsonProperty("thrust_pointing_uncertainty")
    public Double getThrustPointingUncertainty() {
        return thrustPointingUncertainty;
    }

    /**
     * Uncertainty in pointing the thrust, in degrees (one sigma)
     * 
     */
    @JsonProperty("thrust_pointing_uncertainty")
    public void setThrustPointingUncertainty(Double thrustPointingUncertainty) {
        this.thrustPointingUncertainty = thrustPointingUncertainty;
    }

    /**
     * Thrust output, in N
     * 
     */
    @JsonProperty("thrust_output")
    public Double getThrustOutput() {
        return thrustOutput;
    }

    /**
     * Thrust output, in N
     * 
     */
    @JsonProperty("thrust_output")
    public void setThrustOutput(Double thrustOutput) {
        this.thrustOutput = thrustOutput;
    }

    @JsonProperty("propulsion_type")
    public Satellite.PropulsionType getPropulsionType() {
        return propulsionType;
    }

    @JsonProperty("propulsion_type")
    public void setPropulsionType(Satellite.PropulsionType propulsionType) {
        this.propulsionType = propulsionType;
    }

    /**
     * Accepted collision probability
     * 
     */
    @JsonProperty("accepted_collision_probability")
    public Double getAcceptedCollisionProbability() {
        return acceptedCollisionProbability;
    }

    /**
     * Accepted collision probability
     * 
     */
    @JsonProperty("accepted_collision_probability")
    public void setAcceptedCollisionProbability(Double acceptedCollisionProbability) {
        this.acceptedCollisionProbability = acceptedCollisionProbability;
    }

    /**
     * Accepted minimum distance, in km
     * 
     */
    @JsonProperty("accepted_minimum_distance")
    public Double getAcceptedMinimumDistance() {
        return acceptedMinimumDistance;
    }

    /**
     * Accepted minimum distance, in km
     * 
     */
    @JsonProperty("accepted_minimum_distance")
    public void setAcceptedMinimumDistance(Double acceptedMinimumDistance) {
        this.acceptedMinimumDistance = acceptedMinimumDistance;
    }

    /**
     * Use OKAPI AI for risk prediction
     * 
     */
    @JsonProperty("use_ai_risk_prediction")
    public Boolean getUseAiRiskPrediction() {
        return useAiRiskPrediction;
    }

    /**
     * Use OKAPI AI for risk prediction
     * 
     */
    @JsonProperty("use_ai_risk_prediction")
    public void setUseAiRiskPrediction(Boolean useAiRiskPrediction) {
        this.useAiRiskPrediction = useAiRiskPrediction;
    }

    /**
     * Please state your current relationship with SpaceTrack / 18 SPCS concerning this satellite
     * (Required)
     * 
     */
    @JsonProperty("space_track_status")
    public Satellite.SpaceTrackStatus getSpaceTrackStatus() {
        return spaceTrackStatus;
    }

    /**
     * Please state your current relationship with SpaceTrack / 18 SPCS concerning this satellite
     * (Required)
     * 
     */
    @JsonProperty("space_track_status")
    public void setSpaceTrackStatus(Satellite.SpaceTrackStatus spaceTrackStatus) {
        this.spaceTrackStatus = spaceTrackStatus;
    }

    /**
     * If you select "other" for "space_track_status", describe your current relationship here
     * 
     */
    @JsonProperty("space_track_status_other")
    public String getSpaceTrackStatusOther() {
        return spaceTrackStatusOther;
    }

    /**
     * If you select "other" for "space_track_status", describe your current relationship here
     * 
     */
    @JsonProperty("space_track_status_other")
    public void setSpaceTrackStatusOther(String spaceTrackStatusOther) {
        this.spaceTrackStatusOther = spaceTrackStatusOther;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the company name used at SpaceTrack here. By default, this is the company name you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_company_name")
    public String getSpaceTrackCompanyName() {
        return spaceTrackCompanyName;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the company name used at SpaceTrack here. By default, this is the company name you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_company_name")
    public void setSpaceTrackCompanyName(String spaceTrackCompanyName) {
        this.spaceTrackCompanyName = spaceTrackCompanyName;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the Point-of-Contact name used at SpaceTrack here. By default, this is the address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_poc_name")
    public String getSpaceTrackPocName() {
        return spaceTrackPocName;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the Point-of-Contact name used at SpaceTrack here. By default, this is the address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_poc_name")
    public void setSpaceTrackPocName(String spaceTrackPocName) {
        this.spaceTrackPocName = spaceTrackPocName;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the Point-of-Contact address used at SpaceTrack here. By default, this is the address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_poc_address")
    public String getSpaceTrackPocAddress() {
        return spaceTrackPocAddress;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the Point-of-Contact address used at SpaceTrack here. By default, this is the address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_poc_address")
    public void setSpaceTrackPocAddress(String spaceTrackPocAddress) {
        this.spaceTrackPocAddress = spaceTrackPocAddress;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the login used at SpaceTrack here. By default, this is the mail address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_login")
    public String getSpaceTrackLogin() {
        return spaceTrackLogin;
    }

    /**
     * If you select "sharing_agreement_signed", "satellite_registered" or "space_track_account_exists" for "space_track_status", state the login used at SpaceTrack here. By default, this is the mail address you are using at OKAPI.
     * 
     */
    @JsonProperty("space_track_login")
    public void setSpaceTrackLogin(String spaceTrackLogin) {
        this.spaceTrackLogin = spaceTrackLogin;
    }

    /**
     * Active status of this satellite. Indicates if screening is currently activated for this satellite definition. Is set automatically by OKAPI. Immutable by clients.
     * 
     */
    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    /**
     * Active status of this satellite. Indicates if screening is currently activated for this satellite definition. Is set automatically by OKAPI. Immutable by clients.
     * 
     */
    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Preferred collision avoidance maneuver strategy for this satellite
     * 
     */
    @JsonProperty("maneuver_strategy")
    public Satellite.ManeuverStrategy getManeuverStrategy() {
        return maneuverStrategy;
    }

    /**
     * Preferred collision avoidance maneuver strategy for this satellite
     * 
     */
    @JsonProperty("maneuver_strategy")
    public void setManeuverStrategy(Satellite.ManeuverStrategy maneuverStrategy) {
        this.maneuverStrategy = maneuverStrategy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Satellite.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("satelliteId");
        sb.append('=');
        sb.append(((this.satelliteId == null)?"<null>":this.satelliteId));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("noradIds");
        sb.append('=');
        sb.append(((this.noradIds == null)?"<null>":this.noradIds));
        sb.append(',');
        sb.append("area");
        sb.append('=');
        sb.append(((this.area == null)?"<null>":this.area));
        sb.append(',');
        sb.append("mass");
        sb.append('=');
        sb.append(((this.mass == null)?"<null>":this.mass));
        sb.append(',');
        sb.append("thrustUncertainty");
        sb.append('=');
        sb.append(((this.thrustUncertainty == null)?"<null>":this.thrustUncertainty));
        sb.append(',');
        sb.append("thrustPointingUncertainty");
        sb.append('=');
        sb.append(((this.thrustPointingUncertainty == null)?"<null>":this.thrustPointingUncertainty));
        sb.append(',');
        sb.append("thrustOutput");
        sb.append('=');
        sb.append(((this.thrustOutput == null)?"<null>":this.thrustOutput));
        sb.append(',');
        sb.append("propulsionType");
        sb.append('=');
        sb.append(((this.propulsionType == null)?"<null>":this.propulsionType));
        sb.append(',');
        sb.append("acceptedCollisionProbability");
        sb.append('=');
        sb.append(((this.acceptedCollisionProbability == null)?"<null>":this.acceptedCollisionProbability));
        sb.append(',');
        sb.append("acceptedMinimumDistance");
        sb.append('=');
        sb.append(((this.acceptedMinimumDistance == null)?"<null>":this.acceptedMinimumDistance));
        sb.append(',');
        sb.append("useAiRiskPrediction");
        sb.append('=');
        sb.append(((this.useAiRiskPrediction == null)?"<null>":this.useAiRiskPrediction));
        sb.append(',');
        sb.append("spaceTrackStatus");
        sb.append('=');
        sb.append(((this.spaceTrackStatus == null)?"<null>":this.spaceTrackStatus));
        sb.append(',');
        sb.append("spaceTrackStatusOther");
        sb.append('=');
        sb.append(((this.spaceTrackStatusOther == null)?"<null>":this.spaceTrackStatusOther));
        sb.append(',');
        sb.append("spaceTrackCompanyName");
        sb.append('=');
        sb.append(((this.spaceTrackCompanyName == null)?"<null>":this.spaceTrackCompanyName));
        sb.append(',');
        sb.append("spaceTrackPocName");
        sb.append('=');
        sb.append(((this.spaceTrackPocName == null)?"<null>":this.spaceTrackPocName));
        sb.append(',');
        sb.append("spaceTrackPocAddress");
        sb.append('=');
        sb.append(((this.spaceTrackPocAddress == null)?"<null>":this.spaceTrackPocAddress));
        sb.append(',');
        sb.append("spaceTrackLogin");
        sb.append('=');
        sb.append(((this.spaceTrackLogin == null)?"<null>":this.spaceTrackLogin));
        sb.append(',');
        sb.append("active");
        sb.append('=');
        sb.append(((this.active == null)?"<null>":this.active));
        sb.append(',');
        sb.append("maneuverStrategy");
        sb.append('=');
        sb.append(((this.maneuverStrategy == null)?"<null>":this.maneuverStrategy));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.area == null)? 0 :this.area.hashCode()));
        result = ((result* 31)+((this.spaceTrackCompanyName == null)? 0 :this.spaceTrackCompanyName.hashCode()));
        result = ((result* 31)+((this.thrustUncertainty == null)? 0 :this.thrustUncertainty.hashCode()));
        result = ((result* 31)+((this.spaceTrackPocAddress == null)? 0 :this.spaceTrackPocAddress.hashCode()));
        result = ((result* 31)+((this.satelliteId == null)? 0 :this.satelliteId.hashCode()));
        result = ((result* 31)+((this.useAiRiskPrediction == null)? 0 :this.useAiRiskPrediction.hashCode()));
        result = ((result* 31)+((this.noradIds == null)? 0 :this.noradIds.hashCode()));
        result = ((result* 31)+((this.mass == null)? 0 :this.mass.hashCode()));
        result = ((result* 31)+((this.spaceTrackStatus == null)? 0 :this.spaceTrackStatus.hashCode()));
        result = ((result* 31)+((this.active == null)? 0 :this.active.hashCode()));
        result = ((result* 31)+((this.acceptedCollisionProbability == null)? 0 :this.acceptedCollisionProbability.hashCode()));
        result = ((result* 31)+((this.thrustOutput == null)? 0 :this.thrustOutput.hashCode()));
        result = ((result* 31)+((this.spaceTrackStatusOther == null)? 0 :this.spaceTrackStatusOther.hashCode()));
        result = ((result* 31)+((this.thrustPointingUncertainty == null)? 0 :this.thrustPointingUncertainty.hashCode()));
        result = ((result* 31)+((this.propulsionType == null)? 0 :this.propulsionType.hashCode()));
        result = ((result* 31)+((this.spaceTrackPocName == null)? 0 :this.spaceTrackPocName.hashCode()));
        result = ((result* 31)+((this.spaceTrackLogin == null)? 0 :this.spaceTrackLogin.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.maneuverStrategy == null)? 0 :this.maneuverStrategy.hashCode()));
        result = ((result* 31)+((this.acceptedMinimumDistance == null)? 0 :this.acceptedMinimumDistance.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Satellite) == false) {
            return false;
        }
        Satellite rhs = ((Satellite) other);
        return (((((((((((((((((((((this.area == rhs.area)||((this.area!= null)&&this.area.equals(rhs.area)))&&((this.spaceTrackCompanyName == rhs.spaceTrackCompanyName)||((this.spaceTrackCompanyName!= null)&&this.spaceTrackCompanyName.equals(rhs.spaceTrackCompanyName))))&&((this.thrustUncertainty == rhs.thrustUncertainty)||((this.thrustUncertainty!= null)&&this.thrustUncertainty.equals(rhs.thrustUncertainty))))&&((this.spaceTrackPocAddress == rhs.spaceTrackPocAddress)||((this.spaceTrackPocAddress!= null)&&this.spaceTrackPocAddress.equals(rhs.spaceTrackPocAddress))))&&((this.satelliteId == rhs.satelliteId)||((this.satelliteId!= null)&&this.satelliteId.equals(rhs.satelliteId))))&&((this.useAiRiskPrediction == rhs.useAiRiskPrediction)||((this.useAiRiskPrediction!= null)&&this.useAiRiskPrediction.equals(rhs.useAiRiskPrediction))))&&((this.noradIds == rhs.noradIds)||((this.noradIds!= null)&&this.noradIds.equals(rhs.noradIds))))&&((this.mass == rhs.mass)||((this.mass!= null)&&this.mass.equals(rhs.mass))))&&((this.spaceTrackStatus == rhs.spaceTrackStatus)||((this.spaceTrackStatus!= null)&&this.spaceTrackStatus.equals(rhs.spaceTrackStatus))))&&((this.active == rhs.active)||((this.active!= null)&&this.active.equals(rhs.active))))&&((this.acceptedCollisionProbability == rhs.acceptedCollisionProbability)||((this.acceptedCollisionProbability!= null)&&this.acceptedCollisionProbability.equals(rhs.acceptedCollisionProbability))))&&((this.thrustOutput == rhs.thrustOutput)||((this.thrustOutput!= null)&&this.thrustOutput.equals(rhs.thrustOutput))))&&((this.spaceTrackStatusOther == rhs.spaceTrackStatusOther)||((this.spaceTrackStatusOther!= null)&&this.spaceTrackStatusOther.equals(rhs.spaceTrackStatusOther))))&&((this.thrustPointingUncertainty == rhs.thrustPointingUncertainty)||((this.thrustPointingUncertainty!= null)&&this.thrustPointingUncertainty.equals(rhs.thrustPointingUncertainty))))&&((this.propulsionType == rhs.propulsionType)||((this.propulsionType!= null)&&this.propulsionType.equals(rhs.propulsionType))))&&((this.spaceTrackPocName == rhs.spaceTrackPocName)||((this.spaceTrackPocName!= null)&&this.spaceTrackPocName.equals(rhs.spaceTrackPocName))))&&((this.spaceTrackLogin == rhs.spaceTrackLogin)||((this.spaceTrackLogin!= null)&&this.spaceTrackLogin.equals(rhs.spaceTrackLogin))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.maneuverStrategy == rhs.maneuverStrategy)||((this.maneuverStrategy!= null)&&this.maneuverStrategy.equals(rhs.maneuverStrategy))))&&((this.acceptedMinimumDistance == rhs.acceptedMinimumDistance)||((this.acceptedMinimumDistance!= null)&&this.acceptedMinimumDistance.equals(rhs.acceptedMinimumDistance))));
    }


    /**
     * Preferred collision avoidance maneuver strategy for this satellite
     * 
     */
    public enum ManeuverStrategy {

        SHORT_TERM_AND_LONG_TERM("short_term_and_long_term");
        private final String value;
        private final static Map<String, Satellite.ManeuverStrategy> CONSTANTS = new HashMap<String, Satellite.ManeuverStrategy>();

        static {
            for (Satellite.ManeuverStrategy c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ManeuverStrategy(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Satellite.ManeuverStrategy fromValue(String value) {
            Satellite.ManeuverStrategy constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum PropulsionType {

        IMPULSIVE("impulsive"),
        CONTINUOUS("continuous");
        private final String value;
        private final static Map<String, Satellite.PropulsionType> CONSTANTS = new HashMap<String, Satellite.PropulsionType>();

        static {
            for (Satellite.PropulsionType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private PropulsionType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Satellite.PropulsionType fromValue(String value) {
            Satellite.PropulsionType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }


    /**
     * Please state your current relationship with SpaceTrack / 18 SPCS concerning this satellite
     * 
     */
    public enum SpaceTrackStatus {

        SHARING_AGREEMENT_SIGNED("sharing_agreement_signed"),
        SATELLITE_REGISTERED("satellite_registered"),
        SPACE_TRACK_ACCOUNT_EXISTS("space_track_account_exists"),
        NO_SPACE_TRACK_ACCOUNT("no_space_track_account"),
        DONT_KNOW("dont_know"),
        OTHER("other");
        private final String value;
        private final static Map<String, Satellite.SpaceTrackStatus> CONSTANTS = new HashMap<String, Satellite.SpaceTrackStatus>();

        static {
            for (Satellite.SpaceTrackStatus c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private SpaceTrackStatus(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Satellite.SpaceTrackStatus fromValue(String value) {
            Satellite.SpaceTrackStatus constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
