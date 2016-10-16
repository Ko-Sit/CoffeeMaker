package by.nc.sitkin.coffeemachine.entities;

abstract class Ingredient {
    protected Cash cost;

    public Cash getCost(){
        return this.cost;
    }

    public void setCost(Cash cost){
        this.cost = cost;
    }

}
