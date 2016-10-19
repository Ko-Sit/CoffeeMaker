package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Human;
import by.nc.sitkin.coffeemachine.exceptions.WrongCommandException;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String args[]) {
        ArrayList<Human> humans = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nextCommand = "";
        Human currentHuman;

        Menu startMenu = new Menu();
        startMenu.setCommand("create user", new CreateUserCommand(humans));
        startMenu.setCommand("create admin", new CreateAdminCommand(humans));
        startMenu.setCommand("change human", new ChangeHumanCommand(humans));
        startMenu.setCommand("exit", new ExitCommand());
        Menu userMenu = new Menu();
        userMenu.setCommand("select drink", new SelectDrinkCommand());
        userMenu.setCommand("pay money", new PayMoneyCommand());

        while (!nextCommand.equals("change human")) {
            startMenu.printMenu();
            nextCommand = scanner.nextLine().trim().toLowerCase();
            try {
                startMenu.runCommand(nextCommand);
            } catch (WrongCommandException e) {
                System.out.println("No such command!");
            }
        }
        currentHuman = ChangeHumanCommand.getCurrentHuman();
        System.out.println("Reached it!");
        System.out.println(currentHuman.getName());


    }
}
