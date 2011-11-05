package mdx.kata.stringcalc;

import com.google.common.base.Strings;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {
    public int add(String numbers) {
        if (Strings.isNullOrEmpty(numbers)) {
            return 0;
        }
        return Integer.valueOf(numbers);
    }
}
