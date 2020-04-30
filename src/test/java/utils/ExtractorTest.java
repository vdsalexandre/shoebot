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
            "kill bill,Kill Bill Vol. 1 [OST] #14 - The Lonely Shepherd",
            "toy story,Toy Story soundtrack - 04. Andy's Birthday",
            "le laboratoire de dexter,Générique Le laboratoire de Dexter",
            "x files,X Files : Aux frontières du réel - Générique",
            "harry potter,9. \"Statues\" - Harry Potter and the Deathly Hallows: Part 2 (soundtrack)",
            "spiderman,Spider-Man (2002) Main Title by Danny Elfman (HD 1080p)",
            "whiplash,Whiplash Soundtrack 04 - Whiplash",
            "the mentalist,The Mentalist opening credits",
            "la belle et la bete,01 La Belle et la Bête - Prologue",
            "interstellar,Interstellar OST 18 Flying Drone by Hans Zimmer",
            "the shining,The Shining Soundtrack OST Main title HQ",
            "coco,COCO - Un Poco Loco - EU French (Subs & Trans) [HD]",
            "vikings,VIKINGS THEME SONG - If I had a Heart [Soundtrack]",
            "friends,F.R.I.E.N.D.S - Opening Season 1",
            "kid paddle,Kid Paddle générique (HD)",
            "xmen,X-Men (1992) - Générique"})
    void returns_true_when_extracted_word_equals_to_expected_word(String expected, String input) {
        Extractor extractor = new Extractor();
        String extracted = extractor.extract(input);

        assertThat(extracted).isEqualTo(expected);
    }
}
