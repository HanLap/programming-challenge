package de.exxcellent.challenge.adapter;

import de.exxcellent.challenge.model.DailyWeatherData;
import de.exxcellent.challenge.model.FootballResult;
import de.exxcellent.challenge.service.FootballService;
import de.exxcellent.challenge.service.WeatherService;
import de.exxcellent.challenge.util.mapper.ModelMapper;
import de.exxcellent.challenge.util.mapper.ModelMapperException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Adapter that handles the CLI of the application.
 */
public class CliAdapter {

    private final ModelMapper modelMapper;
    private final FootballService footballService;
    private final WeatherService weatherService;

    public CliAdapter(ModelMapper modelMapper, FootballService footballService,
            WeatherService weatherService) {
        this.modelMapper = modelMapper;
        this.footballService = footballService;
        this.weatherService = weatherService;
    }

    public void handleRequest(String... args) {

        if (args.length < 2) {
            System.err.println("Missing parameter");
            printUsage();
            System.exit(1);
        }

        final var program = args[0];
        final var fileLocation = args[1];

        if ("--weather".equals(program)) {
            handleCalcMinTempSpread(fileLocation);

        } else if ("--football".equals(program)) {
            handleCalcMinGoalDistance(fileLocation);

        } else {
            System.err.printf("Invalid argument: %s%n", program);
            printUsage();
            System.exit(1);
        }

    }

    private void handleCalcMinTempSpread(String fileLocation) {

        final var weatherData = parseFileToModel(DailyWeatherData.class, fileLocation);

        try {

            final var dayWithSmallestTempSpread = weatherService.findDayWithSmallestSpread(
                    weatherData
            );

            System.out.printf("Day with smallest temperature spread : %s%n",
                    dayWithSmallestTempSpread);

        } catch (Exception e) {
            System.err.println("Could not determine Day with smallest spread:");
            System.err.println(e.getMessage());
            System.exit(1);

        }
    }

    private void handleCalcMinGoalDistance(String fileLocation) {

        final var footballData = parseFileToModel(FootballResult.class, fileLocation);

        try {

            String teamWithSmallestGoalSpread = footballService.findTeamSmallestGoalDifference(
                    footballData);

            System.out.printf("Team with smallest goal spread: %s%n",
                    teamWithSmallestGoalSpread);

        } catch (Exception e) {
            System.err.println("Could not determine Team with minimum goal distance:");
            System.err.println(e.getMessage());
            System.exit(1);

        }
    }

    private <T> List<T> parseFileToModel(Class<T> clazz, String fileLocation) {

        try {
            final var fileContents = Files.readString(Path.of(fileLocation));

            return modelMapper.mapValuesToClass(clazz, fileContents);

        } catch (IOException e) {
            System.err.printf("File does not exist: %s%n", fileLocation);
            System.exit(1);
        } catch (ModelMapperException e) {
            System.err.printf("Could not parse File: %s%n", fileLocation);
            System.exit(1);
        }

        // will never be executed.
        return List.of();
    }

    private static void printUsage() {
        System.err.println("usage: program [--weather|--football] <FILE.csv>");
    }

}
