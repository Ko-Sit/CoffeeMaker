package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;
import by.nc.sitkin.coffeemachine.exceptions.MissingIngredientException;
import by.nc.sitkin.coffeemachine.files.FileWorker;
import by.nc.sitkin.coffeemachine.enums.Choice;

import java.util.*;

public class CoffeeMachine {
    private Admin admin;
    private List<List<Ingredient>> ingredientSet;

    public CoffeeMachine(){
        this.ingredientSet = new ArrayList<>();
    }

    public CoffeeMachine(List<List<Ingredient>> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

    public CoffeeMachine(Admin admin, List<List<Ingredient>> ingredientSet){
        this.admin = admin;
        this.ingredientSet = ingredientSet;
    }

    public Admin getAdmin(){
        return this.admin;
    }

    public List<List<Ingredient>> getIngredientSet(){
        return this.ingredientSet;
    }

    public void setAdmin(Admin admin){
        this.admin = admin;
    }

    public void setIngredientSet(List<List<Ingredient>> ingredientSet){
        this.ingredientSet = ingredientSet;
    }

    public void produceItem(Choice choice) throws MissingIngredientException {
        Drink drink = null;

        switch (choice){
            case BLACKCOFFEE:
                drink = produceBlackCoffee();
                break;
            case DULCETCOFFEE:
                drink = produceDulcetCoffee();
                break;
            case MILKYCOFFEE:
                drink = produceMilkyCoffee();
                break;
        }
        int dollars = drink.getCost().getDollars();
        int cents = drink.getCost().getCents();

        System.out.println("You'll pay:" + dollars + "." + cents);

        FileWorker.update("totalPrice.txt", dollars, cents);
    }


    private Drink produceBlackCoffee() throws MissingIngredientException {

        ListIterator<List<Ingredient>> iterator = this.ingredientSet.listIterator();
        List<Ingredient> list;
        HashSet<Ingredient> set = new HashSet<>();
        Cash cash;

        list = iterator.next();
        if (list.isEmpty()){
            throw new MissingIngredientException("Coffee");
        }
        cash = list.get(0).getCost();
        set.add(list.remove(0));
        return new Drink("BlackCoffee", cash, set);
    }

    private Drink produceDulcetCoffee() throws MissingIngredientException {
        ListIterator<List<Ingredient>> iterator = this.ingredientSet.listIterator();
        List<Ingredient> list;
        HashSet<Ingredient> set = new HashSet<>();
        Cash cash = new Cash();

        list = iterator.next();
        if (list.isEmpty()){
            throw new MissingIngredientException("Coffee");
        }
        try {
            cash.setDollars(list.get(0).getCost().getDollars());
            cash.setCents(list.get(0).getCost().getCents());
        }
        catch (InvalidValueException e){

        }
        set.add(list.remove(0));
        list = iterator.next();
        if (list.isEmpty()){
            throw new MissingIngredientException("Sugar");
        }
        try {
            cash.setDollars(cash.getDollars() + list.get(0).getCost().getDollars());
            cash.setCents(cash.getCents() + list.get(0).getCost().getCents());
        }
        catch (InvalidValueException e){
        }
        set.add(list.remove(0));
        return new Drink("DulcetCoffee", cash, set);
    }

    private Drink produceMilkyCoffee() throws MissingIngredientException {
        ListIterator<List<Ingredient>> iterator = this.ingredientSet.listIterator();
        List<Ingredient> list;
        HashSet<Ingredient> set = new HashSet<>();
        Cash cash = new Cash();

        list = iterator.next();
        if (list.isEmpty()){
            throw new MissingIngredientException("Coffee");
        }
        try {
            cash.setDollars(list.get(0).getCost().getDollars());
            cash.setCents(list.get(0).getCost().getCents());
        }
        catch (InvalidValueException e){
        }
        set.add(list.remove(0));
        iterator.next();
        list = iterator.next();
        if (list.isEmpty()){
            throw new MissingIngredientException("Milk");
        }
        try {
            cash.setDollars(cash.getDollars() + list.get(0).getCost().getDollars());
            cash.setCents(cash.getCents() + list.get(0).getCost().getCents());
        }
        catch (InvalidValueException e){
        }
        set.add(list.remove(0));
        return new Drink("MilkyCoffee", cash, set);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CoffeeMachine other = (CoffeeMachine) obj;
        if (!getAdmin().equals(other.getAdmin()))
            return false;
        return getIngredientSet().equals(other.getIngredientSet());
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + getAdmin().hashCode();
        result = prime * result + getIngredientSet().hashCode();
        return result;
    }

    @Override
    public String toString(){
        return "" + getClass().getSimpleName() + "@" +
                getAdmin().getName() + " " + getAdmin().getSurname();
    }
}
