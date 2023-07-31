package de.exxcellent.challenge;

import de.exxcellent.challenge.adapter.CliAdapter;
import de.exxcellent.challenge.service.WeatherServiceImpl;
import de.exxcellent.challenge.util.mapper.CsvModelMapper;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as
 * baseline for your software design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        final var moddelMapper = new CsvModelMapper();
        final var weatherService = new WeatherServiceImpl();

        final var cliAdapter = new CliAdapter(moddelMapper, weatherService);

        cliAdapter.handleRequest(args);

    }

}
