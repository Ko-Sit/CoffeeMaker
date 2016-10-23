package by.nc.sitkin.coffeemachine.menus;

import by.nc.sitkin.coffeemachine.commands.Command;
import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.exceptions.WrongCommandException;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Command> menuItems = new HashMap<>();
    private String commands[];

    public Menu(String commands[]){
        this.commands = commands;
    }

    public String getCommand(int value) {
        TypeConverter converter = new TypeConverter();
        while (true) {
            if (value >= 0 && value < commands.length){
                return commands[value];
            }
            else {
                System.out.println("Invalid value!");
                value = converter.getInt("Choice") - 1;
            }
        }
    }

    public void printMenu(){
        System.out.println("-----------------");
        for (int i = 0; i < commands.length; i++){
            System.out.println(i+1 + "." + commands[i]);
        }
        System.out.println("-----------------");
    }

    public void setCommand(String operation, Command cmd){
        menuItems.put(operation, cmd);
    }

    public void runCommand(String operation) {
        menuItems.get(operation).execute();
    }
}
