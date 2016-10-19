package by.nc.sitkin.coffeemachine.runner;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Good Bay!");
        System.exit(0);
    }
}
