package by.nc.sitkin.coffeemachine.entities;

public class Sugar extends Ingredient implements Countable{
    private static int counter = 0;

    public Sugar(){
        this.cost = new Cash(0, 0);
        counter++;
    }

    public Sugar(Cash cost){
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
        Sugar other = (Sugar) obj;
        if (!getCost().equals(other.getCost()))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 23;
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