package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.entities.Person;
import by.nc.sitkin.coffeemachine.entities.User;
import by.nc.sitkin.coffeemachine.interfaces.Command;
import by.nc.sitkin.coffeemachine.utils.UserComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class ExitCommand implements Command {
    private List<Person> persons;

    public ExitCommand(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void execute() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        List<User> users = new ArrayList<>();
        int i = 0;
        for (Person person: persons){
            if (person instanceof User){
                users.add((User)person);
            }
        }

        Collections.sort(users, new UserComparator());
        System.out.println("Sorted list of users for current session:");
        for (User user: users){
            System.out.println(user.getName() + " " + user.getSurname());
        }

        System.out.println("Program ended at:" + gregorianCalendar.getTime());
        System.out.println("Good Bay!");
        System.exit(0);
    }
}
