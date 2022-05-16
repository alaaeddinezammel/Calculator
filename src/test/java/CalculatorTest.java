import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void should_return_sum() {
        Assertions.assertEquals(Calculator.add(""), 0);

    }

    @Test
    void should_handle_many_numbers() {
        Assertions.assertEquals(Calculator.add("1,2,3"), 6);

    }

    @Test
    void should_handle_new_lines() {
        Assertions.assertEquals(Calculator.add("1,2\n3"), 6);

    }

    @Test
    void should_return_sum_when_many_delimiters() {
        Assertions.assertEquals(Calculator.add("//;\n1;2"), 3);
    }

    @Test
    void should_throw_exception_when_input_contains_negative() {

        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> Calculator.add("1,-2,-4,-9,9"),
                "negative numbers are not supported"
        );

    }

    @Test
    void should_throw_exception_when_delimiter_not_supported() {

        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> Calculator.add("1,\n2"),
                "delimiter not supported"
        );

    }
}
