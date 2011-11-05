package mdx.kata.stringcalc;

import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculatorTest {
    @Test
    public void givenEmptyStringReturnsZero() throws Exception {
        String emptyString = "";
        int expectedResult = 0;
        assertResultForGivenInputStringIs(emptyString, expectedResult);
    }

    @Test
    public void givenSingleNumberReturnsItsValue() throws Exception {
        String singleNumber = "123";
        int expectedResult = 123;
        assertResultForGivenInputStringIs(singleNumber, expectedResult);
    }


    private void assertResultForGivenInputStringIs(String inputString, int expectedResult) {
        int actualResult = new StringCalculator().add(inputString);
        assertEquals(format("sum of numbers in input string \"%s\"", inputString), expectedResult, actualResult);
    }
}
