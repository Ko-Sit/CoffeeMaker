package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.entities.Person;
import by.nc.sitkin.coffeemachine.interfaces.Command;
import by.nc.sitkin.coffeemachine.serial.Serializer;

import java.util.List;
import java.util.Scanner;

public class CreateAdminCommand implements Command {
    private List<Person> persons;
    private CoffeeMachine coffeeMachine;

    public CreateAdminCommand(List<Person> persons, CoffeeMachine coffeeMachine) {
        this.persons = persons;
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute(){
        String name;
        String surname;
        Scanner scanner = new Scanner(System.in);
        Serializer serializer = new Serializer();

        System.out.println("Name:");
        name = scanner.next();
        System.out.println("Surname:");
        surname = scanner.next();
        Admin admin = new Admin(name, surname);
        admin.setCoffeeMachine(this.coffeeMachine);
        serializer.serialize(admin);
        this.coffeeMachine.setAdmin(admin);
        persons.add(admin);
    }

}
