package by.nc.sitkin.coffeemachine.runner;

import java.util.Scanner;

/**
 * Created by upsit on 20-Oct-16.
 */
public class TypeConverter {
    public int getInt(String message){
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.println(message + ":");
            try {
                value = Integer.parseInt(scanner.next());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid value!");
            }
        }
        return value;
    }
}
