package utils;

public class Extractor {

    public String extract(String input) {
        String substring = input.substring(0, 2);
        String initInput;
        try {
            Integer.parseInt(substring);
            initInput = input.substring(input.indexOf("(") + 1,
                    input.indexOf(")"));
        } catch (NumberFormatException ex) {
            initInput = input;
        }
        String[] splitedInput = initInput.split("-");
        String[] splitedAgain = splitedInput[0].split("\\|");
        String[] splitOverAndOver = splitedAgain[0].split("Vol.");

        return splitOverAndOver[0]
                .toLowerCase()
                .replace("-", "")
                .replace("|", "")
                .replace("disney", "")
                .replace("soundtrack", "")
                .replace("pixar", "")
                .replace("'s", "")
                .replace("generique", "")
                .replace(".", "")
                .trim();
    }
}

