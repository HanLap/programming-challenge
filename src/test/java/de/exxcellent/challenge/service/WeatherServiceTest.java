package de.exxcellent.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.exxcellent.challenge.model.DailyWeatherData;
import de.exxcellent.challenge.util.ProjectException;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeatherServiceTest {

    @Test
    void shouldFindCorrectDay() throws Exception {
        final WeatherService service = new WeatherServiceImpl();

        var data = List.of(
                new DailyWeatherData(1, 1f, 1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
                new DailyWeatherData(2, 2f, 1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        );
        var actual = service.findDayWithSmallestSpread(data);
        assertEquals(1, actual);

    }

    @Test
    void shouldThrowProjectException() throws Exception {
        final WeatherService service = new WeatherServiceImpl();

        final var nullData = List.of(
                new DailyWeatherData(1, null, null, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        );
        assertThrows(ProjectException.class,
                () -> service.findDayWithSmallestSpread(nullData),
                () -> "Should throw when field is null");

        final List<DailyWeatherData> emptyData = List.of();
        assertThrows(ProjectException.class,
                () -> service.findDayWithSmallestSpread(emptyData),
                () -> "Should throw when data empty");
    }

}
