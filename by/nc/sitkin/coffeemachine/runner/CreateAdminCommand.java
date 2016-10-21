package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.entities.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateAdminCommand implements Command{
    private ArrayList<Human> humans;
    private CoffeeMachine coffeeMachine;

    public CreateAdminCommand(ArrayList<Human> humans, CoffeeMachine coffeeMachine) {
        this.humans = humans;
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute(){
        String name;
        String surname;
        int dollars;
        int cents;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name:");
        name = scanner.next();
        System.out.println("Surname:");
        surname = scanner.next();
        Admin admin = new Admin(name, surname);
        admin.setCoffeeMachine(this.coffeeMachine);
        this.coffeeMachine.setAdmin(admin);
        humans.add(admin);
    }

}
