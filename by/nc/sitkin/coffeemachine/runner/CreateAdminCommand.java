package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateAdminCommand implements Command{
    private ArrayList<Human> humans;

    public CreateAdminCommand(ArrayList<Human> humans) {
        this.humans = humans;
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

        humans.add(new Admin(name, surname));
    }

}
