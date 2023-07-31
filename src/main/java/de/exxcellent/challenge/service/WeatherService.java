package de.exxcellent.challenge.service;

import de.exxcellent.challenge.model.DailyWeatherData;
import de.exxcellent.challenge.util.ProjectException;
import java.util.List;

/**
 * Provides functionality to analyze provided weather data.
 */
public interface WeatherService {

    /**
     * Finds the day with the smallest spread between min temperature and max temperature, from a
     * list of daily weather data.
     *
     * @param weatherData List of weather data.
     * @return Number of the day with the smallest spread.
     * @throws ProjectException If the answer cannot be determined.
     */
    Integer findDayWithSmallestSpread(List<DailyWeatherData> weatherData) throws ProjectException;

}
