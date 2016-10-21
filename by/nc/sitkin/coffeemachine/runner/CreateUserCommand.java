package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Cash;
import by.nc.sitkin.coffeemachine.entities.Human;
import by.nc.sitkin.coffeemachine.entities.User;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateUserCommand implements Command {
    private ArrayList<Human> humans;

    public CreateUserCommand(ArrayList<Human> humans) {
        this.humans = humans;
    }

    @Override
    public void execute(){
        String name;
        String surname;
        int dollars;
        int cents;
        Cash cash;
        Scanner scanner = new Scanner(System.in);
        TypeConverter converter = new TypeConverter();
        System.out.println("Name:");
        name = scanner.next();
        System.out.println("Surname:");
        surname = scanner.next();

        while (true) {
            try {
                dollars = converter.getInt("dollars");
                cents = converter.getInt("cents");
                cash = new Cash(dollars, cents);
                break;
            } catch (InvalidValueException e) {
                //e.printStackTrace();
                System.out.println("Wrong values!");
            }
        }
        humans.add(new User(name, surname, cash));
    }
}
