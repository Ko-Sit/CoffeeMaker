package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.User;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;
import by.nc.sitkin.coffeemachine.files.FileWorker;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class PayMoneyCommand implements Command {
    private User currentHuman;

    public PayMoneyCommand(User currentHuman) {
        this.currentHuman = currentHuman;
    }

    @Override
    public void execute(){

        String resultStr;
        try {
            resultStr = FileWorker.read("totalPrice.txt.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            resultStr = "0.0";
        }
        String result[] = resultStr.split(Pattern.quote("."));
        int dollars = currentHuman.getCash().getDollars() - Integer.parseInt(result[0]);
        int cents = currentHuman.getCash().getCents() - Integer.parseInt(result[1]);
        if (cents < 0){
            dollars = dollars - 1;
            cents = 100 - cents;
        }
        try {
            currentHuman.getCash().setDollars(dollars);
            currentHuman.getCash().setCents(cents);
            System.out.println("Success operation!");
        } catch (InvalidValueException e) {
            System.out.println("You can't afford to buy it!");
        }

    }
}
