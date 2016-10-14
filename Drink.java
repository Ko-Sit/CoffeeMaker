import java.util.ArrayList;

public class Drink extends Ingredient{
    private ArrayList<Ingredient> list;

    Drink(){
        this.list = new ArrayList<Ingredient>();
    }

    Drink(String name, Cash cost, ArrayList<Ingredient> list){
        super(name, cost);
        this.list = list;
    }

    public ArrayList<Ingredient> getList(){
        return this.list;
    }

    public void setList(ArrayList<Ingredient> list){
        this.list = list;
    }

    @Override
    public boolean equals(Object obj){
        if (getClass() != obj.getClass())
            return false;
        Drink other = (Drink) obj;
        return super.equals(other) && getList().equals(other.getList());
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 31;
        result = prime * result + super.hashCode();
        result = prime * result + getList().hashCode();
        return result;
    }

}
