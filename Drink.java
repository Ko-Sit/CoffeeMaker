import java.util.ArrayList;

public class Drink {
    String name;
    ArrayList<Ingredient> list;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Drink other = (Drink) obj;
        if (name != other.name)
            return false;
        if (!list.equals(other.list))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + name.hashCode();
        result = prime * result + list.hashCode();
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getName() + "@" + hashCode();
        return string;
    }

}
