package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Admin extends Person {
    private transient CoffeeMachine coffeeMachine;

    public Admin(){

    }

    public Admin(String name, String surname){
        super(name, surname);
    }

    public CoffeeMachine getCoffeeMachine(){
        return this.coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine){
        this.coffeeMachine = coffeeMachine;
    }

    public void fillMachine() throws InvalidValueException{
        Random random = new Random();
        // TODO: 19-Oct-16  make factory
        List<Ingredient> coffeeSet = new ArrayList<>();
        List<Ingredient> sugarSet = new ArrayList<>();
        List<Ingredient> milkSet = new ArrayList<>();
        Cash coffeeCost = new Cash(15, 94);
        Cash sugarCost = new Cash(0, 85);
        Cash milkCost = new Cash(2, 77);

        for (int i = 0; i < random.nextInt(5) + 5; i++){
            coffeeSet.add(new Coffee(coffeeCost));
            sugarSet.add(new Sugar(sugarCost));
            milkSet.add(new Milk(milkCost));
        }

        List<List<Ingredient>> ingredientSet = new ArrayList<>();
        ingredientSet.add(coffeeSet);
        ingredientSet.add(sugarSet);
        ingredientSet.add(milkSet);
        this.coffeeMachine.setIngredientSet(ingredientSet);
        System.out.println("CoffeeMachine was refilled.");

    }

    @Override
    public boolean equals(Object obj){
      if (getClass() != obj.getClass())
            return false;
      return super.equals(obj);
    }

    @Override
    public int hashCode(){
        final int prime = 19;
        int result = 31;
        result = prime * result + getName().hashCode();
        result = prime * result + getSurname().hashCode();
        return result;
    }

}
