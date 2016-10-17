package by.nc.sitkin.coffeemachine.exceptions;

public class InvalidValueException extends Exception {
    private String message;

    InvalidValueException(){
        this.message = null;
    }

    public InvalidValueException(String message){
        this.message = message;
    }

    public String toString(){
        return "InvalidValueException(" + this.message + ")";

    }
}
