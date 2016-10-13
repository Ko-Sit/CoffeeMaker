
public class Ingredient {
    String name;
    Cash cost;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingredient other = (Ingredient) obj;
        if (name != other.name)
            return false;
        if (!cost.equals(other.cost))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 23;
        int result = 31;
        result = prime * result + name.hashCode();
        result = prime * result + cost.hashCode() ;
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getName() + "@" + hashCode();
        return string;
    }
}
