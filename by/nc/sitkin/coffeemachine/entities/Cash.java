package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

public class Cash {
    protected int dollars;
    protected int cents;

    public Cash(){
        this.dollars = 0;
        this.cents = 0;
    }

    public Cash(int dollars, int cents) throws InvalidValueException{
        if (dollars < 0 || cents < 0){
            throw new InvalidValueException("Parameter is less than zero");
        }
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getDollars(){
        return this.dollars;
    }

    public int getCents(){
        return this.cents;
    }

    public void setDollars(int dollars) throws InvalidValueException{
        if (dollars < 0) {
            throw new InvalidValueException("Dollar value is less than zero");
        }
        this.dollars = dollars;
    }

    public void setCents(int cents) throws InvalidValueException{
        if (cents < 0){
            throw new InvalidValueException("Cents value is less than zero");
        }
        this.cents = cents;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cash other = (Cash) obj;
        if (getDollars() != other.getDollars())
            return false;
        if (getCents() != other.getCents())
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + getDollars();
        result = prime * result + getCents();
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getSimpleName() + "@" + hashCode();
        return string;
    }

}

