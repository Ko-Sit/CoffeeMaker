package by.nc.sitkin.coffeemachine.exceptions;

/**
 * Created by upsit on 24-Oct-16.
 */
public class MissingIngredientException  extends Exception{

    private String message;

    MissingIngredientException(){
        this.message = null;
    }

    public MissingIngredientException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String toString(){
        return "MissingIngredientException(" + this.message + ")";

    }

}
