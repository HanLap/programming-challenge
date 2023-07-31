package de.exxcellent.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Result of a single Team in the English Premier League.
 */
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
@JsonPropertyOrder({"team", "games", "wins", "losses", "draws", "goals", "goalsAllowed", "points"})
public record FootballResult(
        String team,
        Integer games,
        Integer wins,
        Integer losses,
        Integer draws,
        Integer goals,
        @JsonProperty("Goals Allowed") Integer goalsAllowed,
        Integer points
) {

}
