package de.exxcellent.challenge.service;

import de.exxcellent.challenge.model.FootballResult;
import de.exxcellent.challenge.util.ProjectException;
import java.util.List;

/**
 * Provides functionality to analyze provided football results.
 */
public interface FootballService {

    /**
     * Finds the football team which has the smallest distance between
     * {@link de.exxcellent.challenge.model.FootballResult#goals} and
     * {@link de.exxcellent.challenge.model.FootballResult#goalsAllowed}, from a List of football
     * results.
     *
     * @param footballResults List of football resuts.
     * @return Name of the football team with smallest goal distance.
     * @throws ProjectException If the answer cannot be determined.
     */
    String findTeamSmallestGoalDifference(List<FootballResult> footballResults)
            throws ProjectException;

}
