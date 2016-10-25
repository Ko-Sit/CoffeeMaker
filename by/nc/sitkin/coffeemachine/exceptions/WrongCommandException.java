package by.nc.sitkin.coffeemachine.exceptions;

public class WrongCommandException extends Exception{
    private String message;

    public WrongCommandException(){
        this.message = null;
    }

    public WrongCommandException(String message){
        this.message = message;
    }

    public String toString(){
        return "WrongCommandException(" + this.message + ")";

    }
}
