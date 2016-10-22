package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.entities.Human;

import java.util.List;
import java.util.Scanner;

public class CreateAdminCommand implements Command {
    private List<Human> humans;
    private CoffeeMachine coffeeMachine;

    public CreateAdminCommand(List<Human> humans, CoffeeMachine coffeeMachine) {
        this.humans = humans;
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute(){
        String name;
        String surname;
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
