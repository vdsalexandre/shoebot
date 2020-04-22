package utils;

public class Equalizer {
    public int getLength(String input) {
        return input.length();
    }

    public int getScore(String input) {
        int score = 0;
        for (char letter : input.toCharArray()) {
            score += letter;
        }
        return score;
    }

    public int calculateEquals(String input, String expected) {
        int score = 0;

        for (int i = 0; i < expected.length(); i++) {
            if (expected.charAt(i) == input.charAt(i))
                score += expected.charAt(i);
        }

        return score;
    }
}
