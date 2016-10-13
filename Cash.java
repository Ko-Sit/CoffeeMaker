
public class Cash {
    int dollars = 1;
    int cents = 2;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cash other = (Cash) obj;
        if (dollars != other.dollars)
            return false;
        if (cents != other.cents)
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + dollars;
        result = prime * result + cents;
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getName() + "@" + hashCode();
        return string;
    }

}

