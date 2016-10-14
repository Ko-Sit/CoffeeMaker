
public class Cash {
    private int dollars;
    private int cents;

    Cash(){
        this.dollars = 0;
        this.cents = 0;
    }

    Cash(int dollars, int cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getDollars(){
        return this.dollars;
    }

    public int getCents(){
        return this.cents;
    }

    public void setDollars(int dollars){
        this.dollars = dollars;
    }

    public void setCents(int cents){
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
        String string = "" + getClass().getName() + "@" + hashCode();
        return string;
    }

}

