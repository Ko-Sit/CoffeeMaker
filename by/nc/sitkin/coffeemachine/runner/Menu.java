package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.exceptions.WrongCommandException;

import java.util.HashMap;

public class Menu {
    HashMap<String, Command> menuItems = new HashMap<>();

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
