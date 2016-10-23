package by.nc.sitkin.coffeemachine;

import by.nc.sitkin.coffeemachine.commands.*;
import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.entities.*;
import by.nc.sitkin.coffeemachine.exceptions.*;
import by.nc.sitkin.coffeemachine.menus.CurrentMenu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String args[]) throws InvalidValueException, FileNotFoundException {
        TypeConverter converter = new TypeConverter();
        List<Human> humans = new ArrayList<>();
        String nextCommand = "";
        Human currentHuman;
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CurrentMenu currentMenu = new CurrentMenu();
        String startMenuDescription[] = {"create user", "create admin", "change human", "exit"};
        String userMenuDescription[] = {"select drink", "pay money", "back"};
        String adminMenuDescription[] = {"fill machine", "back"};
        int commandIndex;

        while(true){
            while (!nextCommand.equals("change human")) {
                currentMenu.setDefaultMenu(startMenuDescription, humans, coffeeMachine);
                currentMenu.getMenu().printMenu();
                commandIndex = converter.getInt("Choice") - 1;
                nextCommand = currentMenu.getMenu().getCommand(commandIndex);
                if (nextCommand.equals("change human") && humans.isEmpty()){
                    System.out.println("Input some humans first!");
                    nextCommand = "";
                    continue;
                }
                currentMenu.getMenu().runCommand(nextCommand);
            }

            while (!nextCommand.equals("back")) {
                currentHuman = ChangeHumanCommand.getCurrentHuman();
                if (currentHuman instanceof Admin) {
                    currentMenu.setAdminMenu(adminMenuDescription, (Admin)currentHuman);
                } else {
                    currentMenu.setUserMenu(userMenuDescription, (User)currentHuman, coffeeMachine);
                }
                currentMenu.getMenu().printMenu();
                commandIndex = converter.getInt("Choice") - 1;
                nextCommand = currentMenu.getMenu().getCommand(commandIndex);
                currentMenu.getMenu().runCommand(nextCommand);
            }
        }
    }
}
