package by.nc.sitkin.coffeemachine.entities;

import java.util.ArrayList;

public class Drink implements Comparable<Drink>{
    private String name;
    private Cash cost;
    private ArrayList<Ingredient> list;

    public Drink(){
        this.list = new ArrayList<Ingredient>();
    }

    public Drink(String name, Cash cost, ArrayList<Ingredient> list){
        this.name = name;
        this.list = list;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cash getCost() {
        return this.cost;
    }

    public void setCost(Cash cost) {
        this.cost = cost;
    }

    public ArrayList<Ingredient> getList(){
        return this.list;
    }

    public void setList(ArrayList<Ingredient> list){
        this.list = list;
    }

    @Override
    public boolean equals(Object obj){
        if (getClass() != obj.getClass())
            return false;
        Drink other = (Drink) obj;
        return super.equals(other) && getList().equals(other.getList());
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + super.hashCode();
        result = prime * result + getList().hashCode();
        return result;
    }

    @Override
    public int compareTo(Drink obj) {
        double money1 = this.cost.getDollars() + (double)(this.cost.getCents() / 100);
        double money2 = obj.cost.getDollars() + (double)(obj.cost.getCents() / 100);
        if (money1 > money2){
            return 1;
        }
        else if (money1 < money2){
            return -1;
        }
        return 0;
    }
}
