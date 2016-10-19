package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

import java.util.HashSet;
import java.util.Random;

public class Admin extends Human{
    private CoffeeMachine coffeeMachine;
    //todo обработчик неустановленной кофемашины
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
        // TODO: 19-Oct-16  переписать в фабрику
        HashSet<Ingredient> coffeeSet = new HashSet<>();
        HashSet<Ingredient> sugarSet = new HashSet<>();
        HashSet<Ingredient> milkSet = new HashSet<>();
        Cash coffeeCost = new Cash(15, 30);
        Cash sugarCost = new Cash(0, 10);
        Cash milkCost = new Cash(2, 45);

        for (int i = 0; i < random.nextInt(5) + 5; i++){
            coffeeSet.add(new Coffee(coffeeCost));
            sugarSet.add(new Sugar(sugarCost));
            milkSet.add(new Milk(milkCost));
        }

        HashSet<HashSet<Ingredient>> ingredientSet = new HashSet<>();
        ingredientSet.add(coffeeSet);
        ingredientSet.add(sugarSet);
        ingredientSet.add(milkSet);
        this.coffeeMachine.setIngredientSet(ingredientSet);

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
