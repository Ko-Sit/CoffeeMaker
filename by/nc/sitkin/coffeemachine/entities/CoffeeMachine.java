package by.nc.sitkin.coffeemachine.entities;

import java.util.ArrayList;

public class CoffeeMachine {
    //// TODO: 13-Oct-16 Убрать одмена?
    private Admin admin;
    private ArrayList<Ingredient> list;

    // TODO: 13-Oct-16 нью одмен ор нот?
    public CoffeeMachine(){
        this.list = new ArrayList<Ingredient>();
    }

    public CoffeeMachine(Admin admin, ArrayList<Ingredient> list){
        this.admin = admin;
        this.list = list;
    }

    public Admin getAdmin(){
        return this.admin;
    }

    public ArrayList<Ingredient> getList(){
        return this.list;
    }

    public void setAdmin(Admin admin){
        this.admin = admin;
    }

    public void setList(ArrayList<Ingredient> list){
        this.list = list;
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
        if (!getList().equals(other.getList()))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + getAdmin().hashCode();
        result = prime * result + getList().hashCode();
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getSimpleName() + "@" + hashCode();
        return string;
    }

}
