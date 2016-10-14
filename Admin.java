import java.util.Objects;

public class Admin extends Human{
    private CoffeeMachine coffeeMachine;

    Admin(){
        this.coffeeMachine = null;
    }

    Admin(String name, String surname, CoffeeMachine coffeeMachine){
        super(name, surname);
        this.coffeeMachine = coffeeMachine;
    }

    public CoffeeMachine getCoffeeMachine(){
        return this.coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine){
        this.coffeeMachine = coffeeMachine;
    }

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
        result = prime * result + getName().hashCode();
        result = prime * result + getSurname().hashCode();
        return result;
    }

}
