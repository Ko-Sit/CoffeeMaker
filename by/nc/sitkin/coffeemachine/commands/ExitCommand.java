package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.interfaces.Command;

import java.util.GregorianCalendar;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println("Program ended at:" + gregorianCalendar.getTime());
        System.out.println("Good Bay!");
        System.exit(0);
    }
}
