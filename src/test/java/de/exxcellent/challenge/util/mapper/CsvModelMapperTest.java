package de.exxcellent.challenge.util.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class CsvModelMapperTest {

    public record TestClass(String a, Integer b, Float c) {

    }

    @Test
    void shouldMapCorrectly() throws Exception {
        final var mapper = new CsvModelMapper();

        final var data = """
                a,b,c
                A,1,1.2
                """;
        final var actual = mapper.mapValuesToClass(CsvModelMapperTest.TestClass.class, data);
        assertEquals(List.of(new TestClass("A", 1, 1.2f)), actual);
    }


    @Test
    void shouldThrow() {
        final var mapper = new CsvModelMapper();

        final var data = """
                a,b,c
                A,1,1.2,illegal
                """;
        assertThrows(
                ModelMapperException.class,
                () -> mapper.mapValuesToClass(CsvModelMapperTest.TestClass.class, data),
                () -> "Should throw on to many fields");

        final var data1 = """
                a,b,c
                A,wrong,1.2,
                """;
        assertThrows(
                ModelMapperException.class,
                () -> mapper.mapValuesToClass(CsvModelMapperTest.TestClass.class, data1),
                () -> "Should throw on type mismatch");
    }

}
