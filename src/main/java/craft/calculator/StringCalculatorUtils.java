package craft.calculator;

import craft.exception.NegativeInputException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculatorUtils {

    public static int add(String numbersAsString) {
        if (numbersAsString != null && !numbersAsString.isEmpty()) {
            List<Integer> numbers = stringArrayToIntList(splitString(numbersAsString));
            checkIfNegative(numbers);
            return numbers.stream().reduce(Integer::sum).orElseThrow();
        }

        return 0;
    }

    private static void checkIfNegative(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream().filter(x -> x < 0).forEach(stringBuilder::append);
        if (!stringBuilder.toString().isEmpty()) {
            throw new NegativeInputException("negatives not allowed: " + stringBuilder);
        }
    }

    private static List<Integer> stringArrayToIntList(String[] strings) {
        return Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] splitString(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new NumberFormatException("delimiter not supported");
        }
        return input.split("[,\n]");
    }


}
