package challenge_two;

import java.util.HashMap;
import java.util.Map;

public class ChallengeTwo
{
    private static final int LETTER_A_ASCII_VALUE = 65;
    private static final int INPUT_STRING_CHARACTER_INDEX_JUMP = 2;

    private static final char CAPITAL_A = 'A';
    private static final char CAPITAL_Z = 'A';
    private static final char LOWER_CASE_A = 'a';
    private static final char LOWER_CASE_Z = 'z';

    /**
     * Boolean algebra
     * Read a boolean string and its values, and return true or false
     * Test cases:
     * 2 1 1 and(not(A) , not(B))
     * 2 0 0 not(and(A , B))
     * 3 0 0 0 or(and(A , B , C) , and(A , not(B) , C) , and(not(A) , not(B) , C) , and(not(A) , not(B) , not(C)))
     * 3 0 0 0 or(or(and(not(and(A , B)) , not(C)) , and(not(A) , B , C) , and(A , B , C) , and(A , not(B) , not(C))) , and(A , not(B) , C))
     * 3 0 0 0 or(and(A , B , C) , and(A , not(B) , not(and(not(A) , not(C)))))
     */
    public static void main(String[] args) {
        boolean result = challenge("3 0 0 0 or(or(and(not(and(A , B)) , not(C)) , and(not(A) , B , C) , and(A , B , C) , and(A , not(B) , not(C))) , and(A , not(B) , C))");
    }

    private static boolean challenge(String expression) {
        BooleanExpression booleanExpression = mountBooleanExpression(expression);
        return booleanExpression.solve();
    }

    private static BooleanExpression mountBooleanExpression(String expression) {
        String finalExpression = getFinalExpression(expression);

        int firstParenthesisIndex = finalExpression.indexOf('(');
        BooleanOperator operator = BooleanOperator.valueOf(finalExpression.substring(0, firstParenthesisIndex));

        // TODO - Build expression here

        return new BooleanExpression(null, null);
    }

    public static String getFinalExpression(String booleanExpression)
    {
        int startOfExpressionIndex = 0;
        char character = booleanExpression.charAt(startOfExpressionIndex);
        while (!isLetter(character)) {
            startOfExpressionIndex++;
            character = booleanExpression.charAt(startOfExpressionIndex);
        }

        String finalExpression = booleanExpression.substring(startOfExpressionIndex);

        finalExpression = finalExpression.replace(" ", "");

        HashMap<Character, Integer> values = getValuesMap(booleanExpression);

        for (Map.Entry<Character, Integer> set : values.entrySet()) {
            char letter = set.getKey();
            finalExpression = finalExpression.replace(String.valueOf(letter), String.valueOf(set.getValue()));
        }

        return finalExpression;
    }

    private static boolean isLetter(char character) {
        return (character >= CAPITAL_A && character <= CAPITAL_Z) ||
                (character >= LOWER_CASE_A && character <= LOWER_CASE_Z);
    }

    private static HashMap<Character, Integer> getValuesMap(String booleanExpression) {

        HashMap<Character, Integer> values = new HashMap<>();

        int numberOfVariables = Integer.parseInt(String.valueOf(booleanExpression.charAt(0)));
        int valueIndex = 2;
        int letterASCII = LETTER_A_ASCII_VALUE;
        for (int i = 0; i < numberOfVariables; i++) {
            char value = booleanExpression.charAt(valueIndex);
            values.put((char)letterASCII, Integer.parseInt(String.valueOf(value)));
            valueIndex += INPUT_STRING_CHARACTER_INDEX_JUMP;
            letterASCII++;
        }

        return values;
    }

}

