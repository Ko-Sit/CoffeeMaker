package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.entities.Person;
import by.nc.sitkin.coffeemachine.interfaces.Command;

import java.util.List;

public class ChangePersonCommand implements Command {
    private static Person currentPerson;
    private List<Person> persons;

    public ChangePersonCommand(List<Person> persons){
        this.persons = persons;
    }

    public static Person getCurrentPerson(){
        return currentPerson;
    }

    @Override
    public void execute(){
        int number = 1;
        int chosenUserId;
        TypeConverter converter = new TypeConverter();

        for (Person person : persons){
            System.out.println(number + ".(" + person.getClass().getSimpleName() +
                                  ")" + person.getName() + " " + person.getSurname());
            number++;
        }

        while (true) {
            chosenUserId = converter.getInt("Select number") - 1;
            if (chosenUserId >= 0 && chosenUserId < persons.size()){
                break;
            }
            else {
                System.out.println("Invalid value!");
            }
        }

        currentPerson = persons.get(chosenUserId);
    }
}
