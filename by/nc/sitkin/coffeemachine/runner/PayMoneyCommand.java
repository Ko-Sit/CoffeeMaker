package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.User;

public class PayMoneyCommand implements Command {
    private User currentHuman;

    public PayMoneyCommand(User currentHuman) {
        this.currentHuman = currentHuman;
    }

    @Override
    public void execute(){
        // TODO: 19-Oct-16 написать команду


    }
}
