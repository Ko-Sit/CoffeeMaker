package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.entities.Cash;
import by.nc.sitkin.coffeemachine.entities.Person;
import by.nc.sitkin.coffeemachine.entities.User;
import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;
import by.nc.sitkin.coffeemachine.interfaces.Command;

import java.util.List;
import java.util.Scanner;

public class CreateUserCommand implements Command {
    private List<Person> persons;

    public CreateUserCommand(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void execute(){
        String name;
        String surname;
        int dollars;
        int cents;
        Cash cash;
        Scanner scanner = new Scanner(System.in);
        TypeConverter converter = new TypeConverter();
        System.out.println("Name:");
        name = scanner.next();
        System.out.println("Surname:");
        surname = scanner.next();

        while (true) {
            try {
                dollars = converter.getInt("dollars");
                cents = converter.getInt("cents");
                cash = new Cash(dollars, cents);
                break;
            } catch (InvalidValueException e) {
                System.out.println("Wrong values!");
            }
        }
        persons.add(new User(name, surname, cash));
    }
}
