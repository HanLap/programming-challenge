package de.exxcellent.challenge.service;

import de.exxcellent.challenge.model.DailyWeatherData;
import de.exxcellent.challenge.util.ProjectException;
import java.util.List;

public class WeatherServiceImpl implements WeatherService {

    @Override
    public Integer findDayWithSmallestSpread(List<DailyWeatherData> weatherData)
            throws ProjectException {

        for (final var entry : weatherData) {
            if (entry.mxT() == null || entry.mnT() == null) {
                throw new ProjectException("mxT or mnT do not exist on all entries");
            }
        }

        final var resultOptional = weatherData
                .stream()
                .min(this::compareSpread);

        if (resultOptional.isEmpty()) {
            throw new ProjectException("weatherData is empty");
        }

        return resultOptional.get().day();
    }

    private int compareSpread(DailyWeatherData a, DailyWeatherData b) throws ProjectException {
        return (a.mxT() - a.mnT()) > (b.mxT() - b.mnT()) ? 1 : -1;
    }
}
