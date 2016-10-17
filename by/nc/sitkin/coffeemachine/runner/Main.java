package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.*;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Main {

    public static void main(String[] args){
        Cash cash;
        try {
            cash = new Cash(120, 45);
        } catch (InvalidValueException e) {
            System.out.println(e.toString());
            cash = new Cash();
        }
        try {
            cash.setDollars(-4);
        } catch (InvalidValueException e) {
            e.printStackTrace();
        }
        System.out.print(cash.getDollars());

    }
}
