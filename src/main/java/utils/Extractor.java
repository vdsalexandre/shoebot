package utils;

import org.apache.commons.lang3.StringUtils;

public class Extractor {

    public String extract(String input) {
        String[] split1;
        String[] split2;
        if (input.substring(0, 2).matches(".*\\d.*")) { // if starting with digit
            if (input.contains("soundtrack")) { // if contains words to remove inspect part[1]
                split1 = StringUtils.stripAccents(input.toLowerCase()).split(" - ");
                split2 = split1[1].split("\\|");
            } else { // inspect part[0]
                try {
                    String substring = StringUtils.stripAccents(input.toLowerCase()).substring(input.indexOf("(") + 1, input.indexOf(")"));
                    split2 = substring.split("\\|");
                } catch (StringIndexOutOfBoundsException ex) {
                    split1 = StringUtils.stripAccents(input.toLowerCase()).split(" - ");
                    split2 = split1[0].replaceAll("[^A-Za-z ]", "").split("\\|");
                }
            }
        }
        else {
            split1 = StringUtils.stripAccents(input.toLowerCase()).split(" - ");
            split2 = split1[0].split("\\|");
        }

        String[] split3 = split2[0].split(" vol. ");
        String[] split4 = split3[0].split(":");
        String[] split5 = split4[0].split(" and ");
        String[] split6 = split5[0].split("\\(");
        String[] split7 = split6[0].split("soundtrack");
        String[] split8 = split7[0].split(" ost ");

        return split8[0]
                .replace("-", "")
                .replace("|", "")
                .replace("disney", "")
                .replace("pixar", "")
                .replace("'s", "")
                .replace("generique", "")
                .replace(".", "")
                .replace("opening credits", "")
                .replace("theme song", "")
                .trim();
    }
}

