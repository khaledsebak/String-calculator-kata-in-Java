package mdx.kata.stringcalc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {

    public int add(String numbers) {
        List<Integer> terms = parseTerms(numbers);
        ensureNoNegatives(terms);
        return sumOf(terms);
    }

    private void ensureNoNegatives(List<Integer> terms) {
        List<Integer> negatives = new ArrayList<Integer>();
        for (Integer term : terms) {
            if (term < 0) {
                negatives.add(term);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

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
