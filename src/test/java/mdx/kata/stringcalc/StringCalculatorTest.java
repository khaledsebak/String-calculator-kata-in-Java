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
        int actualResult = calculator.add(emptyString);
        assertEquals("result for input string \"" + emptyString + "\"", expectedResult, actualResult);
    }

    @Test
    public void givenSingleNumberReturnsItsValue() throws Exception {
        String singleNumber = "123";
        int expectedResult = 123;
        int actualResult = calculator.add(singleNumber);
        assertEquals("result for input string \"" + singleNumber + "\"", expectedResult, actualResult);
    }
}
