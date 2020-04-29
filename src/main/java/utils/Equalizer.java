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
            try {
                if (expected.toLowerCase().charAt(i) == input.toLowerCase().charAt(i))
                    score++;
            } catch (StringIndexOutOfBoundsException ex) {
                return score;
            }
        }

        return score;
    }

    public int countWords(String input) {
        return input.split(" ").length;
    }

    public boolean compare(String input, String expected) {
        String[] expectedWords = expected.split(" ");
        String[] inputWords = input.split(" ");
        int expectedScore = expected.replaceAll(" ", "").length();
        int score = 0;

        if (expectedWords.length == inputWords.length) {
            for (int i = 0; i < expectedWords.length; i++) {
                score += calculateEquals(inputWords[i], expectedWords[i]);
            }

            return expectedScore == score;
        }
        return false;
    }
}
