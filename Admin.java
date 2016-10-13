import java.util.Objects;

public class Admin extends Human{
    private CoffeeMachine coffeeMachine;

    @Override
    public boolean equals(Object obj){
      if (getClass() != obj.getClass())
            return false;
      return super.equals(obj);
    }

    @Override
    public int hashCode(){
        final int prime = 19;
        int result = 31;
        result = prime * result + name.hashCode();
        result = prime * result + surname.hashCode();
        return result;
    }

}
