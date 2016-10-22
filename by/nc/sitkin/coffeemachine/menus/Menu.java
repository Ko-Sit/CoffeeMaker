package by.nc.sitkin.coffeemachine.menus;

import by.nc.sitkin.coffeemachine.commands.Command;
import by.nc.sitkin.coffeemachine.exceptions.WrongCommandException;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<String, Command> menuItems = new HashMap<>();

    public void printMenu(){
        for (String key: menuItems.keySet()){
            System.out.println(key);
        }
        System.out.println("-----------------");
    }

    public void setCommand(String operation, Command cmd){
        menuItems.put(operation, cmd);
    }

    public void runCommand(String operation) throws WrongCommandException {
        if (menuItems.keySet().contains(operation)) {
            menuItems.get(operation).execute();
        }
        else{
            throw new WrongCommandException();
        }
    }
}
