package de.exxcellent.challenge;

import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void runApp() throws Exception {

        final var weatherFile = Path.of(
                AppTest.class.getClassLoader().getResource("de/exxcellent/challenge/weather.csv")
                        .toURI()).toString();
        assertDoesNotThrow(() -> App.main("--weather", weatherFile));

        final var footballFile = Path.of(
                AppTest.class.getClassLoader().getResource("de/exxcellent/challenge/football.csv")
                        .toURI()).toString();
        assertDoesNotThrow(() -> App.main("--football", footballFile));
    }

}