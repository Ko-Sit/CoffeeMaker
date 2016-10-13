
public class Human {
    String name = "vasya";
    String surname = "polkov";

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (name != other.name)
            return false;
        if (surname != other.surname)
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 17;
        int result = 31;
        result = prime * result + name.hashCode();
        result = prime * result + surname.hashCode();
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getName() + "@" + hashCode();
        return string;
    }
}






