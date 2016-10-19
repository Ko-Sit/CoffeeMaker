package by.nc.sitkin.coffeemachine.entities;

import java.util.HashSet;

public class CoffeeMachine {
    private Admin admin;
    private HashSet<HashSet<Ingredient>> ingredientSet;


    public CoffeeMachine(){
        this.ingredientSet = new HashSet<>();
    }

    public CoffeeMachine(HashSet<HashSet<Ingredient>> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

    public CoffeeMachine(Admin admin, HashSet<HashSet<Ingredient>> ingredientSet){
        this.admin = admin;
        this.ingredientSet = ingredientSet;
    }

    public Admin getAdmin(){
        return this.admin;
    }

    public HashSet<HashSet<Ingredient>> getIngredientSet(){
        return this.ingredientSet;
    }

    public void setAdmin(Admin admin){
        this.admin = admin;
    }

    public void setIngredientSet(HashSet<HashSet<Ingredient>> ingredientSet){
        this.ingredientSet = ingredientSet;
    }


    public void produceItem() {
        // TODO: 19-Oct-16 произвести что нибудь

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
