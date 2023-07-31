package de.exxcellent.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Weather data for a single day.
 */
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
@JsonPropertyOrder({"Day", "mxT", "mnT", "AvT", "AvDP", "1HrP TPcpn", "Pdir", "AvSp", "Dir", "MxS",
    "SkyC", "MxR", "Mn", "R AvSLP"})
public record DailyWeatherData(
    Integer day,
    Float mxT,
    Float mnT,
    Float avT,
    Float avDP,
    @JsonProperty("1HrP TPcpn") Float oneHrP_TPcpn,
    Float pDir,
    Float avSp,
    Float dir,
    Float mxS,
    Float skyC,
    Float mxR,
    Float mn,
    @JsonProperty("R AvSLP") Float r_AvSLP
) {

}
