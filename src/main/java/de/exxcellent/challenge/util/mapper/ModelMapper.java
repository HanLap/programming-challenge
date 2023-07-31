package de.exxcellent.challenge.util.mapper;

import java.util.List;

/**
 * Provides funbctionality to map structured data of a certain format to a given class
 * representation.
 */
public interface ModelMapper {

    /**
     * Maps a String containing values, to a List of Objects of class T.
     *
     * @param clazz  Class which the values should be cast to.
     * @param values Input String containing the values as structured data.
     * @return The mapped values as a list ob Objects of class T.
     * @throws ModelMapperException if values cannot be mapped to the given clazz.
     */
    <T> List<T> mapValuesToClass(Class<T> clazz, String values) throws ModelMapperException;

}
