package by.nc.sitkin.coffeemachine.files;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by upsit on 21-Oct-16.
 */
public class FileWorker {
    public static void write(String filePath, String fileName, String text) {
        File file = new File(filePath, fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try(PrintWriter out = new PrintWriter(file.getAbsoluteFile())){
                out.print(text);
            }
        }
        catch(IOException e) {
            System.out.println("Some troubles with file writing..");
        }
    }

    public static String read(String filePath, String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(filePath, fileName);
            File file = new File(filePath, fileName);
        try {
            try(BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
        } catch(IOException e) {
            System.out.println("Some troubles with file reading..");
        }
        return sb.toString();
    }

    private static void exists(String filePath, String fileName) throws FileNotFoundException {
        File file = new File(filePath, fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getAbsolutePath());
        }
    }

    public static void update(String filePath, String fileName, int dollars, int cents){
        String resultStr;
        try {
            exists(filePath, fileName);
            resultStr = read(filePath, fileName);
        } catch (FileNotFoundException e) {
            resultStr = "0.0";
        }
        if (resultStr.equals("")) {
            resultStr = "0.0";
        }
        String result[] = resultStr.split(Pattern.quote("."));
        dollars += Integer.parseInt(result[0]);
        cents += Integer.parseInt(result[1]);
        dollars += cents / 100;
        cents %= 100;
        // point moves trash to res[2]
        resultStr = "" + dollars + "." + cents + ".";
        FileWorker.write(filePath, fileName, resultStr);
    }

    public static void delete(String filePath, String fileName) throws FileNotFoundException {
        exists(filePath, fileName);
        new File(filePath, fileName).delete();
    }
}


