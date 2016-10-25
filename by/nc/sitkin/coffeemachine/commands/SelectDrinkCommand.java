package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.enums.Choice;
import by.nc.sitkin.coffeemachine.interfaces.Command;

public class SelectDrinkCommand implements Command {
    private CoffeeMachine coffeeMachine;

    public SelectDrinkCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute() {
        TypeConverter converter = new TypeConverter();
        System.out.println("1.coffee");
        System.out.println("2.coffee + sugar");
        System.out.println("3.coffee + milk");
        System.out.println("-----------------");
        int chosenDrink = converter.getInt("Input number");
        Choice choice;
        switch (chosenDrink){
            case 1:
                choice = Choice.BLACKCOFFEE;
                break;
            case 2:
                choice = Choice.DULCETCOFFEE;
                break;
            case 3:
                choice = Choice.MILKYCOFFEE;
                break;
            default:
                System.out.println("Wrong number!");
                return;
        }

        coffeeMachine.produceItem(choice);

    }
}
