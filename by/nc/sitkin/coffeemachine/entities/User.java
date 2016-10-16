package by.nc.sitkin.coffeemachine.entities;

public class User extends Human{
    private Cash cash;

    public User(){
        this.cash = new Cash();
    }

    public User(String name, String surname, Cash cash){
        super(name, surname);
        this.cash = cash;
    }

    public Cash getCash(){
        return this.cash;
    }

    public void setCash(Cash cash){
        this.cash = cash;
    }

    @Override
    public boolean equals(Object obj){
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return super.equals(other) && getCash().equals(other.getCash());
    }

    @Override
    public int hashCode(){
        final int prime = 11;
        int result = 31;
        result = prime * result + super.hashCode();
        result = prime * result + getCash().hashCode();
        return result;
    }

}
