package craft.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorUtils {

    public static int add(String numbersAsString) {
        if (!numbersAsString.isEmpty()) {
            List<Integer> numbers = strArrToIntList(getSplit(numbersAsString));
            negativesNumbers(numbers);
            return numbers.stream().reduce(Integer::sum).orElseThrow();
        }
        return 0;
    }

    private static void negativesNumbers(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream().filter(x -> x < 0).forEach(x -> stringBuilder.append(x).append(" "));
        if (!stringBuilder.toString().isEmpty()) {
            throw new RuntimeException("negatives not allowed" + stringBuilder);
        }
    }

    private static List<Integer> strArrToIntList(String[] strings) {
        return Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] getSplit(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new RuntimeException("delimiter not supported");
        }
        return input.split("[,\n]");
    }
}
