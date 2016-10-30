package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.entities.Ingredient;
import by.nc.sitkin.coffeemachine.interfaces.Command;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by upsit on 29-Oct-16.
 */
public class ShowStatusCommand implements Command {
    private CoffeeMachine coffeeMachine;

    public ShowStatusCommand(CoffeeMachine coffeeMachine){
        this.coffeeMachine = coffeeMachine;
    }
    @Override
    public void execute(){
        List<List<Ingredient>> list = coffeeMachine.getIngredientSet();
        if (list.isEmpty()){
            System.out.println("There's no ingredients yet...");
            return;
        }
        System.out.println("Coffee " + list.get(0).size());
        System.out.println("Sugar " + list.get(1).size());
        System.out.println("Milk " + list.get(2).size());

    }
}
