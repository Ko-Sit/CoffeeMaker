package by.nc.sitkin.coffeemachine;

import by.nc.sitkin.coffeemachine.commands.*;
import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.entities.*;
import by.nc.sitkin.coffeemachine.menus.CurrentMenu;
import by.nc.sitkin.coffeemachine.serial.Serializer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static void main(String args[]) {
        TypeConverter converter = new TypeConverter();
        List<Person> persons = new ArrayList<>();
        Serializer serializer = new Serializer();
        String nextCommand = "";
        Person currentPerson;
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CurrentMenu currentMenu = new CurrentMenu();
        String startMenuDescription[] = {"create user", "create admin", "change person", "exit"};
        String userMenuDescription[] = {"select drink", "pay money", "back"};
        String adminMenuDescription[] = {"fill machine", "back"};
        int commandIndex;

        while(true){
            while (!nextCommand.equals("change person")) {
                currentMenu.setDefaultMenu(startMenuDescription, persons, coffeeMachine);
                currentMenu.getMenu().printMenu();
                commandIndex = converter.getInt("Choice") - 1;
                nextCommand = currentMenu.getMenu().getCommand(commandIndex);
                if (nextCommand.equals("change person") && persons.isEmpty()){
                    System.out.println("Person list is empty, loaded admin from last session");
                    Admin admin = (Admin) serializer.deserialize();
                    admin.setCoffeeMachine(coffeeMachine);
                    persons.add(admin);
                    nextCommand = "";
                    continue;
                }
                currentMenu.getMenu().runCommand(nextCommand);
            }

            while (!nextCommand.equals("back")) {
                currentPerson = ChangePersonCommand.getCurrentPerson();
                if (currentPerson instanceof Admin) {
                    currentMenu.setAdminMenu(adminMenuDescription, (Admin) currentPerson);
                } else {
                    currentMenu.setUserMenu(userMenuDescription, (User) currentPerson, coffeeMachine);
                }
                currentMenu.getMenu().printMenu();
                commandIndex = converter.getInt("Choice") - 1;
                nextCommand = currentMenu.getMenu().getCommand(commandIndex);
                currentMenu.getMenu().runCommand(nextCommand);
            }
        }
    }
}
