package by.nc.sitkin.coffeemachine.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Drink implements Comparable<Drink>{
    private String name;
    private Cash cost;
    private Set<Ingredient> set;

    public Drink(){
        this.set = new HashSet<>();
    }

    public Drink(String name, Cash cost, Set<Ingredient> set){
        this.name = name;
        this.set = set;
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

    public Set<Ingredient> getSet(){
        return this.set;
    }

    public void setSet(Set<Ingredient> set){
        this.set = set;
    }

    @Override
    public boolean equals(Object obj){
        if (getClass() != obj.getClass())
            return false;
        Drink other = (Drink) obj;
        return super.equals(other) && getSet().equals(other.getSet());
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + super.hashCode();
        result = prime * result + getSet().hashCode();
        return result;
    }

    @Override
    public String toString(){
        return "" + getClass().getSimpleName() + "@" +
                getName() + getCost().getDollars() + "." + getCost().getCents();
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
