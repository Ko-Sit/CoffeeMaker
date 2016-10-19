package by.nc.sitkin.coffeemachine.entities;

public abstract class Ingredient {
    protected Cash cost;

    public Cash getCost(){
        return this.cost;
    }

    public void setCost(Cash cost){
        this.cost = cost;
    }

}
