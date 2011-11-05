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
        assertResultForGivenInputStringIs(emptyString, 0);
    }

    @Test
    public void givenSingleNumberReturnsItsValue() throws Exception {
        String singleNumber = "123";
        int valueOfTheNumber = 123;
        assertResultForGivenInputStringIs(singleNumber, valueOfTheNumber);
    }

    @Test
    public void givenPairOfComaSeparatedNumbersReturnTheirSum() throws Exception {
        String pairOfNumbers = "5,13";
        int sumOfNumbers = 5 + 13;
        assertResultForGivenInputStringIs(pairOfNumbers, sumOfNumbers);
    }

    private void assertResultForGivenInputStringIs(String inputString, int expectedResult) {
        int actualResult = new StringCalculator().add(inputString);
        assertEquals(format("sum of numbers in input string \"%s\"", inputString), expectedResult, actualResult);
    }
}