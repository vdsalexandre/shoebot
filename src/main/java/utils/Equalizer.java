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
}
