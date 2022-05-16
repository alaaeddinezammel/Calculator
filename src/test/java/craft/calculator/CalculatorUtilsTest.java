package craft.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorUtilsTest {

    @Test
    void should_return_sum() {
        Assertions.assertEquals(CalculatorUtils.add(""), 0);

    }

    @Test
    void should_handle_many_numbers() {
        Assertions.assertEquals(CalculatorUtils.add("1,2,3"), 6);

    }

    @Test
    void should_handle_new_lines() {
        Assertions.assertEquals(CalculatorUtils.add("1,2\n3"), 6);

    }

    @Test
    void should_return_sum_when_many_delimiters() {
        Assertions.assertEquals(CalculatorUtils.add("//;\n1;2"), 3);
    }

    @Test
    void should_throw_exception_when_input_contains_negative() {

        Assertions.assertThrows(
                RuntimeException.class,
                () -> CalculatorUtils.add("1,-2,-4,-9,9"),
                "negatives not allowed"
        );

    }

    @Test
    void should_throw_exception_when_delimiter_not_supported() {

        Assertions.assertThrows(
                RuntimeException.class,
                () -> CalculatorUtils.add("1,\n2"),
                "delimiter not supported"
        );

    }
}
