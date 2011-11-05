package mdx.kata.stringcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class NumbersParser {

    public static final Pattern separatorDefinitionPattern = Pattern.compile("^(//(.)\n).*$");
    public static final String noNumbersRegex = "^(//.\n)?$";
    public static final String defaultSeparatorRegex = "[,\n]";

    private final String numbersString;

    public NumbersParser(String input) {
        this.numbersString = input;
    }

    public List<Integer> parseIntegers() {
        List<String> stringTerms = new ArrayList<String>();
        if (containsNumbers(numbersString)) {
            stringTerms.addAll(split(numbersString));
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

    private List<String> split(String input) {
        String separator = defaultSeparatorRegex;
        String numbers = input;
        Matcher separatorDefinitionMatcher = separatorDefinitionPattern.matcher(input);
        if (separatorDefinitionMatcher.matches()) {
            separator = separatorDefinitionMatcher.group(2);
            numbers = input.substring(separatorDefinitionMatcher.group(1).length());
        }
        return asList(numbers.split(separator));
    }

    private boolean containsNumbers(String input) {
        return !input.matches(noNumbersRegex);
    }

    private Integer toInteger(String input) {
        return Integer.valueOf(input);
    }

}
