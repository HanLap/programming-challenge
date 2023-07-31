package de.exxcellent.challenge.service;

import de.exxcellent.challenge.model.FootballResult;
import de.exxcellent.challenge.util.ProjectException;
import java.util.List;

public class FootballServiceImpl implements FootballService {

    @Override
    public String findTeamSmallestGoalDifference(List<FootballResult> footballResults)
            throws ProjectException {

        for (final var result : footballResults) {
            if (result.goals() == null || result.goalsAllowed() == null) {
                throw new ProjectException("goal or goals allowed does not exist on all entries");
            }
        }

        final var resultOptional = footballResults
                .stream()
                .min(this::compareGoalDistance);

        if (resultOptional.isEmpty()) {
            throw new ProjectException("Football result list is empty");
        }

        return resultOptional.get().team();
    }

    private int compareGoalDistance(FootballResult a, FootballResult b) {
        final var deltaA = Math.abs(a.goals() - a.goalsAllowed());
        final var deltaB = Math.abs(b.goals() - b.goalsAllowed());

        return deltaA > deltaB ? 1 : -1;
    }
}
