package challenge_three;

import java.util.HashMap;

public class ChallengeThree
{
    /**
     * Given a string, count the number of each
     * character in it
     */
    public static void main(String[] args) {
        String str = "BANANA";
        HashMap<Character, Integer> charCount = getCharacterCount(str);
        System.out.println(charCount);
    }

    private static HashMap<Character, Integer> getCharacterCount(String word) {
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            Integer count = characterCount.get(character);
            if (count == null) {
                characterCount.put(word.charAt(i), 0);
            }
            count = characterCount.get(character);
            characterCount.put(character, count + 1);
        }
        return characterCount;
    }
}
