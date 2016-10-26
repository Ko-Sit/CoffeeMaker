package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;

/**
 *
 * Class {@code Cash} is used as cost of some goods
 * or current money of {@code User}
 * @author  konstantin sitkin
 */
public class Cash {
    private int dollars;
    private int cents;

    /**
     * default values should be zero
     */
    public Cash(){
        this.dollars = 0;
        this.cents = 0;
    }

    /**
     *
     * @param dollars positive int only
     * @param cents   positive int only
     * @throws InvalidValueException if parameters are invalid
     * cent value can't be more 99, bigger values will be cast
     */
    public Cash(int dollars, int cents) throws InvalidValueException{
        if (dollars < 0 || cents < 0){
            throw new InvalidValueException("Parameter is less than zero");
        }
        this.dollars = dollars + cents / 100;
        this.cents = cents % 100;
    }

    public int getDollars(){
        return this.dollars;
    }

    public int getCents(){
        return this.cents;
    }

    /**
     *
     * @param dollars positive int only
     * @throws InvalidValueException if parameter is invalid
     */
    public void setDollars(int dollars) throws InvalidValueException{
        if (dollars < 0) {
            throw new InvalidValueException("Dollar value is less than zero");
        }
        this.dollars = dollars;
    }

    /**
     *
     * @param cents positive int only
     * @throws InvalidValueException if parameter is invalid
     */
    public void setCents(int cents) throws InvalidValueException{
        if (cents < 0){
            throw new InvalidValueException("Cents value is less than zero");
        }
        this.dollars += cents / 100;
        this.cents = cents % 100;
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
        return getCents() == other.getCents();
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
        return "" + getClass().getSimpleName() + "@" + hashCode();
    }

}

