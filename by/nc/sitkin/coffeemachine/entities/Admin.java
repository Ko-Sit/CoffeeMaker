package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * Class {@code Admin} rules condition of coffeemachine.
 * after deserialize needs  to set current CM
 *  @author konstantin sitkin
 * @see    CoffeeMachine
* */
public class Admin extends Person {
    private transient CoffeeMachine coffeeMachine;
    private static final int CAPACITY = 10;

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

    /**
     * creates ingredients and puts it in coffeemachine
     * @throws InvalidValueException if ingredient cost is invalid
     */
    public void fillMachine() throws InvalidValueException{
        TypeConverter converter = new TypeConverter();
        // TODO: 19-Oct-16  make factory
        if (this.coffeeMachine.getIngredientSet().isEmpty()) {
           initIngredientSet();
        }
        int chosenFiller = converter.getInt("Input number");
        switch (chosenFiller){
            case 1:
                fillCoffee();
                break;
            case 2:
                fillSugar();
                break;
            case 3:
                fillMilk();
                break;
            case 4:
                fillCoffee();
                fillSugar();
                fillMilk();
        }

        System.out.println("CoffeeMachine was refilled.");
    }

    private void initIngredientSet() {
        List<Ingredient> coffeeSet = new ArrayList<>();
        List<Ingredient> sugarSet = new ArrayList<>();
        List<Ingredient> milkSet = new ArrayList<>();

        List<List<Ingredient>> ingredientSet = new ArrayList<>();
        ingredientSet.add(coffeeSet);
        ingredientSet.add(sugarSet);
        ingredientSet.add(milkSet);
        this.coffeeMachine.setIngredientSet(ingredientSet);
    }

    private void fillCoffee() throws InvalidValueException {
        List<Ingredient> coffeeSet = this.coffeeMachine.getIngredientSet().get(0);
        Cash coffeeCost = new Cash(10, 0);
        coffeeSet.clear();
        for (int i = 0; i < CAPACITY && coffeeSet.size() < CAPACITY; i++){
            coffeeSet.add(new Coffee(coffeeCost));
        }
    }

    private void fillSugar() throws InvalidValueException {
        List<Ingredient> sugarSet = this.coffeeMachine.getIngredientSet().get(1);
        Cash sugarCost = new Cash(0, 5);

        for (int i = 0; i < CAPACITY && sugarSet.size() < CAPACITY; i++){
            sugarSet.add(new Coffee(sugarCost));
        }
    }

    private void fillMilk() throws InvalidValueException {
        List<Ingredient> milkSet = this.coffeeMachine.getIngredientSet().get(2);
        Cash milkCost = new Cash(3, 0);

        for (int i = 0; i < CAPACITY && milkSet.size() < CAPACITY; i++){
            milkSet.add(new Coffee(milkCost));
        }
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
