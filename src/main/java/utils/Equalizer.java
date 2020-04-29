package utils;

public class Equalizer {
    public int getLength(String input) {
        return input.length();
    }

    public int getScore(String input) {
        return input.chars().sum();
    }

    public int calculateEquals(String input, String expected) {
        int score = 0;

        for (int i = 0; i < expected.length(); i++) {
            try {
                if (normalize(expected).charAt(i) == normalize(input).charAt(i))
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

    private boolean hasSameLetters(String expectedWord, String inputWord) {
        int count = 0;
        for (char c : normalize(expectedWord).toCharArray()) {
            if (normalize(inputWord).contains(String.valueOf(c)))
                count++;
        }

        return count == expectedWord.length();
    }

    private String normalize(String inputValue) {
        return inputValue.toLowerCase();
    }

    private String clean(String inputValue) {
        return inputValue.replaceAll(" ", "");
    }

    public boolean compareCloseWords(String expected, String input) {
        return hasSameLetters(expected, input) && hasSameScore(expected, input);
    }

    private boolean hasSameScore(String expected, String input) {
        return getScore(normalize(expected)) == getScore(normalize(input));
    }

    public int getPercentageOf(String expected, String input) {
        double expectedScore = getScore(clean(normalize(expected)));
        double inputScore = getScore(clean(normalize(input)));
        double percentage = inputScore / expectedScore * 100;

        return (int) Math.round(percentage);
    }

    public boolean isPercentageBiggerOrEqualTo90(int percentage) {
        return percentage >= 90;
    }
}
