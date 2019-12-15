package utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("[YYYY-MM-dd HH:mm:ss]");
    private static File logFile = null;

    public static void trace(Class classe, String message) {
        System.out.println(sdf.format(new Date()) + " --> " + classe + " : " + message);
    }

    private static void appendToFile(String fileName, String message) throws IOException {
        Writer output = new BufferedWriter(new FileWriter(fileName, true));
        output.append(message);
        output.close();
    }

    private static void initFile() {
        if (logFile == null) {
            logFile = new File(Utils.getProperty("app.discord.logs.file")); 
        }
    }
}
