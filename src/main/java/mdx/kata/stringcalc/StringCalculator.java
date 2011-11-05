package mdx.kata.stringcalc;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {
    /**
     * @param comaSeparatedNumbers coma-separated numbers
     * @return sum of numbers (1 or 2) contained in the input string (<code>0</code> for empty string)
     */
    public int add(String comaSeparatedNumbers) {
        List<Integer> terms = parseTerms(comaSeparatedNumbers);
        return sumOf(terms);
    }

    private List<Integer> parseTerms(String comaSeparatedNumbers) {
        List<String> stringTerms = Lists.newArrayList();
        if (containsMultipleComaSeparatedNumbers(comaSeparatedNumbers)) {
            stringTerms.addAll(split(comaSeparatedNumbers));
        } else if (isASingleNumber(comaSeparatedNumbers)) {
            stringTerms.add(comaSeparatedNumbers);
        }
        return parseIntegers(stringTerms);
    }

    private boolean isASingleNumber(String comaSeparatedNumbers) {
        return !comaSeparatedNumbers.isEmpty();
    }

    private boolean containsMultipleComaSeparatedNumbers(String comaSeparatedNumbers) {
        return comaSeparatedNumbers.contains(",");
    }

    private List<Integer> parseIntegers(List<String> stringTerms) {
        return transform(stringTerms, new Function<String, Integer>() {
            public Integer apply(String input) {
                return toInteger(input);
            }
        });
    }

    private List<String> split(String comaSeparatedNumbers) {
        String[] numbers = comaSeparatedNumbers.split(",");
        return Arrays.asList(numbers);
    }

    private Integer toInteger(String input) {
        return Integer.valueOf(input);
    }

    private int sumOf(List<Integer> terms) {
        int sum = 0;
        for (Integer term : terms) {
            sum += term;
        }
        return sum;
    }
}
