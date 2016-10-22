package by.nc.sitkin.coffeemachine.entities;

public class Human {
    protected String name;
    protected String surname;

    public Human(){
        this.name = "N/A";
        this.surname = "N/A";
    }

    public Human(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (!getName().equals(other.getName()))
            return false;
        return getSurname().equals(other.getSurname());
    }

    @Override
    public int hashCode(){
        final int prime = 17;
        int result = 31;
        result = prime * result + getName().hashCode();
        result = prime * result + getSurname().hashCode();
        return result;
    }

    @Override
    public String toString(){
        return "" + getClass().getSimpleName() + "@" + hashCode();
    }
}






