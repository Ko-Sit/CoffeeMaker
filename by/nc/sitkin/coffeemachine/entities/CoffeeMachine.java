package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.runner.CHOICE;

import java.awt.*;
import java.util.*;

public class CoffeeMachine {
    private Admin admin;
    private ArrayList<ArrayList<Ingredient>> ingredientSet;


    public CoffeeMachine(){
        this.ingredientSet = new ArrayList<>();
    }

    public CoffeeMachine(ArrayList<ArrayList<Ingredient>> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

    public CoffeeMachine(Admin admin, ArrayList<ArrayList<Ingredient>> ingredientSet){
        this.admin = admin;
        this.ingredientSet = ingredientSet;
    }

    public Admin getAdmin(){
        return this.admin;
    }

    public ArrayList<ArrayList<Ingredient>> getIngredientSet(){
        return this.ingredientSet;
    }

    public void setAdmin(Admin admin){
        this.admin = admin;
    }

    public void setIngredientSet(ArrayList<ArrayList<Ingredient>> ingredientSet){
        this.ingredientSet = ingredientSet;
    }


    public void produceItem(CHOICE choice) {
        // TODO: 19-Oct-16 произвести что нибудь
        int dollars = 0;
        int cents = 0;
        for (ArrayList<Ingredient> iter : ingredientSet){
            dollars += iter.get(0).getCost().dollars;
            cents += iter.get(0).getCost().cents;
            iter.remove(0);
        }



        switch (choice){
            case blackCoffee:

                //Drink blackCoffee = new Drink("blackcoffee", )
                break;
            case dulcetCoffee:
                break;
            case milkyCoffee:
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
        if (!getIngredientSet().equals(other.getIngredientSet()))
            return false;
        return true;
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
        String string = "" + getClass().getSimpleName() + "@" + hashCode();
        return string;
    }
}
