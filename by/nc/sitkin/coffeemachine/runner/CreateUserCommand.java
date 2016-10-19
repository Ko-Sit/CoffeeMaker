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

        System.out.println("Name:");
        name = scanner.next();
        System.out.println("Surname:");
        surname = scanner.next();
        System.out.println("dollars:");
        dollars = scanner.nextInt();
        System.out.println("cents:");
        cents = scanner.nextInt();

        try {
            cash = new Cash(dollars, cents);
        } catch (InvalidValueException e) {
            e.printStackTrace();
            cash = new Cash();
        }

        humans.add(new User(name, surname, cash));
    }
}
