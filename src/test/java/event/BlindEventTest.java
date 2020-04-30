package event;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlindEventTest {

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
}