package mdx.kata.stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class StringCalculator {

    public static final String separatorDefinitionRegex = "^(//(.)\n).*$";
    public static final String noNumbersRegex = "^(//.\n)?$";
    public static final String defaultSeparatorRegex = "[,\n]";

    public int add(String comaSeparatedNumbers) {
        List<Integer> terms = parseTerms(comaSeparatedNumbers);
        return sumOf(terms);
    }

    private List<Integer> parseTerms(String input) {
        List<String> stringTerms = new ArrayList<String>();
        if (containsNumbers(input)) {
            stringTerms.addAll(split(input));
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

    private List<String> split(String inputWithPossibleSeparatorDefinitionLine) {
        String separatorRegex = getSeparator(inputWithPossibleSeparatorDefinitionLine);
        String numbersString = stripSeparatorLineFrom(inputWithPossibleSeparatorDefinitionLine);
        String[] numbers = numbersString.split(separatorRegex);
        return Arrays.asList(numbers);
    }

    private String stripSeparatorLineFrom(String input) {
        Matcher separatorDefinitionMatcher = Pattern.compile(separatorDefinitionRegex).matcher(input);
        if (separatorDefinitionMatcher.matches()) {
            return input.substring(separatorDefinitionMatcher.group(1).length());
        }
        return input;
    }

    private boolean containsNumbers(String input) {
        return !input.matches(noNumbersRegex);
    }

    private String getSeparator(String input) {
        Matcher separatorDefinitionMatcher = Pattern.compile(separatorDefinitionRegex).matcher(input);
        if (separatorDefinitionMatcher.matches()) {
            return separatorDefinitionMatcher.group(2);
        }
        return defaultSeparatorRegex;
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
