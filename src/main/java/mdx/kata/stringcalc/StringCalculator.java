package mdx.kata.stringcalc;

import com.google.common.base.Strings;

import static java.lang.Integer.valueOf;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {
    /**
     * @param numbers coma-separated numbers
     * @return sum of numbers (1 or 2) contained in the input string (<code>0</code> for empty string)
     */
    public int add(String numbers) {
        if (Strings.isNullOrEmpty(numbers)) {
            return 0;
        }
        if (numbers.contains(",")) {
            String[] bothNumbers = numbers.split(",");
            return valueOf(bothNumbers[0]) + valueOf(bothNumbers[1]);

        }
        return valueOf(numbers);
    }
}
