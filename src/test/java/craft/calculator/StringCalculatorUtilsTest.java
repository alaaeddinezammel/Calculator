package craft.calculator;

import craft.exception.NegativeInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorUtilsTest {

    @Test
    void should_return_zero_when_empty_string() {
        Assertions.assertEquals(StringCalculatorUtils.add(""), 0);
    }

    @Test
    void should_not_throw_exception_when_input_is_null() {
        Assertions.assertEquals(StringCalculatorUtils.add(null), 0);

    }

    @Test
    void should_return_sum_when_input_contains_many_numbers() {
        Assertions.assertEquals(StringCalculatorUtils.add("1,2,3"), 6);

    }

    @Test
    void should_return_sum_when_input_contains_new_lines() {
        Assertions.assertEquals(StringCalculatorUtils.add("1,2\n3"), 6);

    }

    @Test
    void should_return_sum_when_input_contains_many_delimiters() {
        Assertions.assertEquals(StringCalculatorUtils.add("//;\n1;2"), 3);
    }

    @Test
    void should_throw_exception_when_input_contains_negative_number() {

        Assertions.assertThrows(
                NegativeInputException.class,
                () -> StringCalculatorUtils.add("1,-2,-4,-9,9"),
                "negatives not allowed"
        );

    }

    @Test
    void should_throw_exception_when_delimiter_is_not_supported() {

        Assertions.assertThrows(
                NumberFormatException.class,
                () -> StringCalculatorUtils.add("1,\n2"),
                "delimiter not supported"
        );

    }
}
