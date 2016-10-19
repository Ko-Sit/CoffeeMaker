package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.Human;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

public class FillMachine implements Command {
    private Admin currentHuman;

    public FillMachine(Admin currentHuman) {
        this.currentHuman = currentHuman;
    }

    @Override
    public void execute() {
        try {
            currentHuman.fillMachine();
        }
        catch (InvalidValueException e){
            System.out.println("admin broke it. c");
        }
    }
}
