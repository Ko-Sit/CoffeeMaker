package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Cash;
import by.nc.sitkin.coffeemachine.entities.User;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

import java.util.Scanner;

public class CreateUserCommand implements Command {

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

        User user = new User(name, surname, cash);
    }
}
