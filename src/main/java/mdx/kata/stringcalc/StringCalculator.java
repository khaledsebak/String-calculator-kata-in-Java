package mdx.kata.stringcalc;

import java.util.List;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {

    public int add(String numbers) {
        List<Integer> terms = parseTerms(numbers);
        return sumOf(terms);
    }

    private List<Integer> parseTerms(String input) {
        return new NumbersParser(input).parseIntegers();
    }

    private int sumOf(List<Integer> terms) {
        int sum = 0;
        for (Integer term : terms) {
            sum += term;
        }
        return sum;
    }
}
