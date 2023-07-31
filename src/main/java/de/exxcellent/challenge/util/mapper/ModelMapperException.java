package de.exxcellent.challenge.util.mapper;

public class ModelMapperException extends RuntimeException {

    public ModelMapperException() {
    }

    public ModelMapperException(String message) {
        super(message);
    }

    public ModelMapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelMapperException(Throwable cause) {
        super(cause);
    }
}
