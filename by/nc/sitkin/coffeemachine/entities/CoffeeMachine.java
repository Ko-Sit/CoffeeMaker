package by.nc.sitkin.coffeemachine.entities;

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

    public void produceItem(Choice choice) {
        if (this.ingredientSet.isEmpty()){
            System.out.println("CoffeeMachine is empty, call admin");
            return;
        }
        int dollars = 0;
        int cents = 0;

        ListIterator<List<Ingredient>> iterator = this.ingredientSet.listIterator();
        List<Ingredient> list;

        while (iterator.hasNext()){
            list = iterator.next();
            dollars += list.get(0).getCost().dollars;
            cents += list.get(0).getCost().cents;
            list.remove(0);
        }
        dollars += cents / 100;
        cents %= 100;
        System.out.println("You'll pay:" + dollars + "." + cents);

        FileWorker.update("totalPrice.txt", dollars, cents);

        switch (choice){
            case BLACKCOFFEE:
                //Drink BLACKCOFFEE = new Drink("blackcoffee", )
                break;
            case DULCETCOFFEE:
                break;
            case MILKYCOFFEE:
                break;
        }

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
        return "" + getClass().getSimpleName() + "@" + hashCode();
    }
}
