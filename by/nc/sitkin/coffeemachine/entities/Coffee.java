package by.nc.sitkin.coffeemachine.entities;

public class Coffee extends Ingredient implements Countable{
    private static int counter = 0;

    public Coffee(){
        this.cost = new Cash(0, 0);
        counter++;
    }

    public Coffee(Cash cost){
        this.cost = cost;
        counter++;
    }

    public int getCounter(){
        return counter;
    }

    public void decrement(){
        counter--;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coffee other = (Coffee) obj;
        if (!getCost().equals(other.getCost()))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 41;
        int result = 31;
        result = prime * result + getClass().getSimpleName().hashCode();
        result = prime * result + getCounter();
        result = prime * result + getCost().hashCode();
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getSimpleName() + "@" + hashCode();
        return string;
    }
}