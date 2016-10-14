
public class Ingredient {
    private String name;
    private Cash cost;

    Ingredient(){
        this.name = "N/A";
        this.cost = new Cash(0, 0);
    }

    Ingredient(String name, Cash cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName(){
        return this.name;
    }
    public Cash getCost(){
        return this.cost;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCost(Cash cost){
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingredient other = (Ingredient) obj;
        if (!getName().equals(other.getName()))
            return false;
        if (!getCost().equals(other.getCost()))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 23;
        int result = 31;
        result = prime * result + getName().hashCode();
        result = prime * result + getCost().hashCode() ;
        return result;
    }

    @Override
    public String toString(){
        String string = "" + getClass().getName() + "@" + hashCode();
        return string;
    }
}
