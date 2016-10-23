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
        int chosenUserId;
        TypeConverter converter = new TypeConverter();

        for (Human human : humans){
            System.out.println(number + ".(" + human.getClass().getSimpleName() +
                                  ")" + human.getName() + " " + human.getSurname());
            number++;
        }

        while (true) {
            chosenUserId = converter.getInt("Select number") - 1;
            if (chosenUserId >= 0 && chosenUserId < humans.size()){
                break;
            }
            else {
                System.out.println("Invalid value!");
            }
        }

        currentHuman = humans.get(chosenUserId);
    }
}
