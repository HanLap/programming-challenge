package de.exxcellent.challenge.util.mapper;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.io.IOException;
import java.util.List;

/**
 * ModelMapper implementation for the handling of CSV data.
 */
public class CsvModelMapper implements ModelMapper {

    @Override
    public <T> List<T> mapValuesToClass(Class<T> clazz, String values)
            throws ModelMapperException {

        try {
            final var mapper = new CsvMapper();
            final var data = mapper
                    .readerFor(clazz)
                    .with(mapper.schemaFor(clazz).withHeader())
                    .readValues(values)
                    .readAll();

            return (List<T>) data;

        } catch (IOException e) {
            throw new ModelMapperException("Could not map values", e);
        }
    }
}
