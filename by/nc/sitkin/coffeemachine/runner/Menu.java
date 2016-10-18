package by.nc.sitkin.coffeemachine.runner;

import java.util.HashMap;

public class Menu {
    HashMap<String, Command> menuItems = new HashMap<>();

    public void setCommand(String operation, Command cmd){
        menuItems.put(operation, cmd);
    }

    public void runCommand(String operation){
        menuItems.get(operation).execute();
    }
}
