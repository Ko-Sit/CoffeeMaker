package by.nc.sitkin.coffeemachine.files;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by upsit on 21-Oct-16.
 */
public class FileWorker {
    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);
            File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getName()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public static void update(String fileName, int dollars, int cents){
        String resultStr;
        try {
            exists(fileName);
            resultStr = read(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        FileWorker.write(fileName, resultStr);
    }

    public static void delete(String nameFile) throws FileNotFoundException {
        exists(nameFile);
        new File(nameFile).delete();
    }
}


