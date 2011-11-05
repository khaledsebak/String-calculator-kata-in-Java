package mdx.kata.stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {

    public int add(String comaSeparatedNumbers) {
        List<Integer> terms = parseTerms(comaSeparatedNumbers);
        return sumOf(terms);
    }

    private List<Integer> parseTerms(String comaSeparatedNumbers) {
        List<String> stringTerms = new ArrayList<String>();
        if (!comaSeparatedNumbers.isEmpty()) {
            stringTerms.addAll(split(comaSeparatedNumbers));
        }
        return parseIntegers(stringTerms);
    }

    private List<Integer> parseIntegers(List<String> stringTerms) {
        List<Integer> terms = new ArrayList<Integer>();
        for (String stringTerm : stringTerms) {
            terms.add(toInteger(stringTerm));
        }
        return terms;
    }

    private List<String> split(String comaSeparatedNumbers) {
        String separatorRegex = "[,\n]";
        String[] numbers = comaSeparatedNumbers.split(separatorRegex);
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
