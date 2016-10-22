package by.nc.sitkin.coffeemachine;

import by.nc.sitkin.coffeemachine.commands.*;
import by.nc.sitkin.coffeemachine.entities.*;
import by.nc.sitkin.coffeemachine.exceptions.*;
import by.nc.sitkin.coffeemachine.menus.Menu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String args[]) throws InvalidValueException, FileNotFoundException {

        List<Human> humans = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nextCommand = "";
        Human currentHuman;
        // empty machine default, fill by admin before using
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Menu startMenu = new Menu();
        startMenu.setCommand("create user", new CreateUserCommand(humans));
        startMenu.setCommand("create admin", new CreateAdminCommand(humans, coffeeMachine));
        startMenu.setCommand("change human", new ChangeHumanCommand(humans));
        startMenu.setCommand("exit", new ExitCommand());
        Menu userMenu = new Menu();
        Menu adminMenu = new Menu();
        while(true){
            //change visible?
            while (!nextCommand.equals("change human")) {
                startMenu.printMenu();
                nextCommand = scanner.nextLine().trim().toLowerCase();
                if (nextCommand.equals("change human") && humans.isEmpty()){
                    System.out.println("Input some humans first!");
                    nextCommand = "";
                    continue;
                }
                try {
                    startMenu.runCommand(nextCommand);
                } catch (WrongCommandException e) {
                    System.out.println("No such command!");
                }
            }
            currentHuman = ChangeHumanCommand.getCurrentHuman();
            //need to refresh parameters in commands
            while (!nextCommand.equals("back")) {
                if (currentHuman instanceof Admin) {
                    adminMenu.setCommand("fill machine", new FillMachineCommand((Admin) currentHuman));
                    adminMenu.setCommand("back", new BackCommand());
                    adminMenu.printMenu();
                } else {
                    userMenu.setCommand("select drink", new SelectDrinkCommand(coffeeMachine));
                    userMenu.setCommand("pay money", new PayMoneyCommand((User)currentHuman));
                    userMenu.setCommand("back", new BackCommand());
                    userMenu.printMenu();
                }
                nextCommand = scanner.nextLine().trim().toLowerCase();
                try {
                    userMenu.runCommand(nextCommand);

                } catch (WrongCommandException e) {
                    try {
                        adminMenu.runCommand(nextCommand);

                    } catch (WrongCommandException w) {
                        System.out.println("No such command!");
                    }
                }
            }

        }
    }
}
