package event;

import org.junit.jupiter.api.Test;
import utils.Equalizer;

import static org.assertj.core.api.Assertions.assertThat;

class BlindEventTest {

    @Test
    void testSettings() {
        assertThat(true).isTrue();
    }

    @Test
    void returns_true_when_one_word_equals_another_word() {
        String expectedWord = "Guns N' Roses - Welcome To The Jungle";
        String inputWord = "Guns N' Roses - Welcome To The Jungle";

        assertThat(inputWord).isEqualTo(expectedWord);
    }

    @Test
    void returns_true_when_one_word_equals_another_word_ignoring_case() {
        String expectedWord = "Guns N' Roses - Welcome To The Jungle";
        String inputWord = "guns n' roses - welcome to the jungle";

        assertThat(inputWord).isEqualToIgnoringCase(expectedWord);
    }

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
    void name() {
        Equalizer equalizer = new Equalizer();
        String expected = "admin";
        String input = "ADMIN";
        int score = equalizer.calculateEquals(input, expected);
    }
}