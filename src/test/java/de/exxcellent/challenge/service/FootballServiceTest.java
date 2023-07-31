package de.exxcellent.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.exxcellent.challenge.model.FootballResult;
import de.exxcellent.challenge.util.ProjectException;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class FootballServiceTest {

    @Test
    void shouldFindCorrectDay() throws Exception {
        final FootballService service = new FootballServiceImpl();

        var data = List.of(
                new FootballResult("A", 0, 0, 0, 0, 1, 1, 0),
                new FootballResult("B", 0, 0, 0, 0, 2, 1, 0)
        );
        var actual = service.findTeamSmallestGoalDifference(data);
        assertEquals("A", actual);

        data = List.of(
                new FootballResult("A", 0, 0, 0, 0, 1, 1, 0),
                new FootballResult("B", 0, 0, 0, 0, 1, 2, 0)
        );
        actual = service.findTeamSmallestGoalDifference(data);
        assertEquals("A", actual, () -> "Should take absolute value of goals");
    }

    @Test
    void shouldThrowProjectException() throws Exception {
        final FootballService service = new FootballServiceImpl();

        final List<FootballResult> nullData = List.of(
                new FootballResult("A", 0, 0, 0, 0, null, null, 0)
        );
        assertThrows(ProjectException.class,
                () -> service.findTeamSmallestGoalDifference(nullData),
                () -> "Should throw when field null");

        final List<FootballResult> emptyData = List.of();
        assertThrows(ProjectException.class,
                () -> service.findTeamSmallestGoalDifference(emptyData),
                () -> "Should throw when data empty");
    }

}
