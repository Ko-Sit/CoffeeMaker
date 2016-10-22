package by.nc.sitkin.coffeemachine.commands;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Good Bay!");
        System.exit(0);
    }
}
