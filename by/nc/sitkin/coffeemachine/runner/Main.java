package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Cash cash = new Cash(120, 45);
        Human human = new Human("Brus", "Ekkel");
        Admin admin = new Admin("Bill", "Gates", new CoffeeMachine());
        User user = new User("Konstantin", "Sitkin", cash);
        System.out.println("--------------------------------");
        Milk milk1 = new Milk(new Cash(0, 33));
        System.out.println(milk1.getCounter());
        System.out.println(new Milk());
        System.out.println(new Milk());
        System.out.println(new Milk());
        System.out.println(new Milk());
        System.out.println(new Milk());
        System.out.println(milk1.getCounter());
        System.out.println("--------------------------------");
        Sugar sugar = new Sugar(new Cash(0, 4));
        System.out.println(sugar.getCounter());
        System.out.println(new Sugar());
        System.out.println(new Sugar());
        System.out.println(new Sugar());
        System.out.println(new Sugar());
        System.out.println(sugar.getCounter());
        System.out.println(sugar.getCost().getCents());
        sugar.setCost(new Cash(2, 12));
        System.out.println(sugar.getCost().getDollars());
        System.out.println(sugar.getCost().getCents());
        System.out.println("--------------------------------");
        Coffee coffee = new Coffee();
        System.out.println(coffee.getCounter());
        System.out.println(new Coffee());
        System.out.println(new Coffee());
        System.out.println(new Coffee());
        System.out.println(coffee.getCounter());
    }
}
