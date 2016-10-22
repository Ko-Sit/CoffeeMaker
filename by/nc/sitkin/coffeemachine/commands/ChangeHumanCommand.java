package by.nc.sitkin.coffeemachine.commands;

import by.nc.sitkin.coffeemachine.converters.TypeConverter;
import by.nc.sitkin.coffeemachine.entities.Human;

import java.util.List;

public class ChangeHumanCommand implements Command {
    private static Human currentHuman;
    private List<Human> humans;

    public ChangeHumanCommand(List<Human> humans){
        this.humans = humans;
    }

    public static Human getCurrentHuman(){
        return currentHuman;
    }

    @Override
    public void execute(){
        int number = 1;
        TypeConverter converter = new TypeConverter();

        for (Human human : humans){
            System.out.println(number + ".(" + human.getClass().getSimpleName() +
                                  ")" + human.getName() + " " + human.getSurname());
            number++;
        }

        Integer chosenUserId = converter.getInt("Select number") - 1;
        currentHuman = humans.get(chosenUserId);
    }
}
