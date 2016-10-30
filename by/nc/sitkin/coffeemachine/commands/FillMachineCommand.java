package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;
import by.nc.sitkin.coffeemachine.interfaces.Command;

public class FillMachineCommand implements Command {
    private Admin currentHuman;

    public FillMachineCommand(Admin currentHuman) {
        this.currentHuman = currentHuman;
    }

    @Override
    public void execute() {
        System.out.println("-----------------");
        System.out.println("1.fill coffee");
        System.out.println("2.fill sugar");
        System.out.println("3.fill milk");
        System.out.println("4.fill all");
        System.out.println("-----------------");

        try {
            currentHuman.fillMachine();
        }
        catch (InvalidValueException e){
            System.out.println("admin broke it.");
        }
    }
}
