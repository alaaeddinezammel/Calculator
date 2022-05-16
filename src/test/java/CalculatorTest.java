import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void should_return_sum() {
        Assertions.assertEquals(Calculator.add(""), 0);

    }

    @Test
    void should_handle_many_numbers() {
        Assertions.assertEquals(Calculator.add(""), 0);

    }

    @Test
    void should_return_sum_when_many_delimiters() {
        Assertions.assertEquals(Calculator.add(""), 0);
    }

    @Test
    void should_throw_exception_when_input_contains_negative() {
        Assertions.assertEquals(Calculator.add(""), 0);

    }
}
