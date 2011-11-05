package mdx.kata.stringcalc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    public void createCalculator() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void givenEmptyStringReturnsZero() throws Exception {
        String emptyString = "";
        int expectedResult = 0;
        int result = calculator.add(emptyString);
        assertEquals("result for input string \"" + emptyString + "\"", expectedResult, result);
    }

}
