
public class User extends Human{
    private Cash cash = new Cash();

    @Override
    public boolean equals(Object obj){
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return super.equals(obj) && cash.equals(other.cash);
    }

    @Override
    public int hashCode(){
        final int prime = 11;
        int result = 31;
        result = prime * result + super.hashCode();
        result = prime * result + cash.hashCode();
        return result;
    }

}
