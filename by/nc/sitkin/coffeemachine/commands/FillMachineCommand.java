package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

public class FillMachineCommand implements Command {
    private Admin currentHuman;

    public FillMachineCommand(Admin currentHuman) {
        this.currentHuman = currentHuman;
    }

    @Override
    public void execute() {
        try {
            currentHuman.fillMachine();
        }
        catch (InvalidValueException e){
            System.out.println("admin broke it.");
        }
    }
}
