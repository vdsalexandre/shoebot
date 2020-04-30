package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtractorTest {

    @ParameterizedTest
    @CsvSource({"mulan,Mulan - Comme un homme | Disney",
            "braveheart,Braveheart Soundtrack - Main Title",
            "la casa de papel,La Casa de Papel | My Life Is Going On - - Cecilia Krull (Vídeo Oficial)",
            "inside out,Disney Pixar's Inside Out - 01 - Bundle Of Joy",
            "eternal sunshine of the spotless mind,Eternal Sunshine of The Spotless Mind - Theme (Jon Brion)",
            "dr house,Generique Dr. House",
            "kung fu panda,01. Hero - Hans Zimmer (Kung Fu Panda Soundtrack)",
            "kill bill,Kill Bill Vol. 1 [OST] #14 - The Lonely Shepherd"})
    void returns_true_when_extracted_word_equals_to_expected_word(String expected, String input) {
        Extractor extractor = new Extractor();
        String extracted = extractor.extract(input);

        assertThat(extracted).isEqualTo(expected);
    }
}
