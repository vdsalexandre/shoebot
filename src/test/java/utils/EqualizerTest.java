package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Equalizer;

import static org.assertj.core.api.Assertions.assertThat;

public class EqualizerTest {

    @Test
    void returns_true_when_length_is_equal_between_two_words() {
        String expectedWord = "Welcome To The Jungle";
        String inputWord = "WeLcOmE tO ThE jUnGlE";

        Equalizer equalizer = new Equalizer();
        int inputLength = equalizer.getLength(inputWord);
        int expectedLength = equalizer.getLength(expectedWord);

        assertThat(inputLength).isEqualTo(expectedLength);
    }

    @Test
    void returns_false_when_score_is_different_between_two_words() {
        String expectedWord = "Welcome To The Jungle";
        String inputWord = "WELCOME TO THE JUNGLE";

        Equalizer equalizer = new Equalizer();
        int inputScore = equalizer.getScore(inputWord);
        int expectedScore = equalizer.getScore(expectedWord);

        assertThat(inputScore).isNotEqualTo(expectedScore);
    }

    @Test
    void returns_true_when_two_words_have_the_same_letters() {
        String expected = "admin";
        String input = "ADMIN";
        int expectedScore = expected.length(); // each letter in commun equals 1

        Equalizer equalizer = new Equalizer();
        int score = equalizer.calculateEquals(input, expected);

        assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    void returns_true_when_count_words_is_right() {
        String input = "Welcome to the jungle";
        int expectedCountWords = 4;

        Equalizer equalizer = new Equalizer();
        int countWords = equalizer.countWords(input);

        assertThat(countWords).isEqualTo(expectedCountWords);
    }

    @Test
    void returns_true_when_two_words_have_the_same_count_of_words() {
        String input = "Welcome to the jungle";
        String expected = "Welcom to th jungle";

        Equalizer equalizer = new Equalizer();
        int expectedCountWords = equalizer.countWords(expected);
        int countWords = equalizer.countWords(input);

        assertThat(countWords).isEqualTo(expectedCountWords);
    }

    @Test
    void returns_true_when_two_sentences_have_the_same_score() {
        String input = "Welcome to the jungle";
        String expected = "welcome to the JUNGLE";

        Equalizer equalizer = new Equalizer();
        boolean sameWords = equalizer.compare(input, expected);

        assertThat(sameWords).isTrue();
    }

    @Test
    void returns_true_when_two_different_words_have_same_length_and_same_letters() {
        String input = "jungel";
        String expected = "Jungle";

        Equalizer equalizer = new Equalizer();
        boolean closeWords = equalizer.compareCloseWords(expected, input);

        assertThat(closeWords).isTrue();
    }

    @Test
    void returns_true_when_word_percentage_is_between_90_and_100_percent() {
        String input = "welcomE to the jungl";
        String expected = "Welcome To The Jungle";

        Equalizer equalizer = new Equalizer();
        boolean isCloseWord = equalizer.isPercentageBiggerOrEqualTo(expected, input, 90);

        assertThat(isCloseWord).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"coco,CoC", "independence day,Independancday",
            "la belle et la bete,la bell et la bet", "anastasia,anastasa"})
    void returns_true_when_small_word_percentage_is_between_70_and_100_percent(String expected, String input) {
        Equalizer equalizer = new Equalizer();

        boolean isCloseWord = equalizer.isPercentageBiggerOrEqualTo(expected, input, 80);
        assertThat(isCloseWord).isTrue();
    }
}
