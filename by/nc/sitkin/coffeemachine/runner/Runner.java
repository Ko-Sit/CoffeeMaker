package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.*;
import by.nc.sitkin.coffeemachine.exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String args[]) throws InvalidValueException {
        ArrayList<Human> humans = new ArrayList<>();
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
        // нужно рефрешить юзеров и админов в командах
        Menu userMenu = new Menu();
        Menu adminMenu = new Menu();

            while (true) {
                if (currentHuman instanceof Admin) {
                    //right cast?
                    adminMenu.setCommand("fill machine", new FillMachine((Admin)currentHuman));
                    adminMenu.printMenu();
                }
                else{
                    userMenu.setCommand("select drink", new SelectDrinkCommand(coffeeMachine));
                    userMenu.setCommand("pay money", new PayMoneyCommand(currentHuman));
                    userMenu.printMenu();
                }
                nextCommand = scanner.nextLine().trim().toLowerCase();
                try {
                    userMenu.runCommand(nextCommand);
                    //Drink menu


                    break;
                } catch (WrongCommandException e) {
                    try{
                        adminMenu.runCommand(nextCommand);
                        break;
                    }
                    catch (WrongCommandException w){
                        System.out.println("No such command!");
                    }
                }
            }

    }
}
