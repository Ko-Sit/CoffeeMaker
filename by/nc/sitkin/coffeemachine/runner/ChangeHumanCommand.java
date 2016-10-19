package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeHumanCommand implements Command {
    private static Human currentHuman;
    private ArrayList<Human> humans;

    public ChangeHumanCommand(ArrayList<Human> humans){
        this.humans = humans;
    }

    public static Human getCurrentHuman(){
        return currentHuman;
    }

    @Override
    public void execute(){
        int number = 1;
        Scanner scanner = new Scanner(System.in);

        for (Human human : humans){
            System.out.println(number + ".(" + human.getClass().getSimpleName() +
                                  ")" + human.getName() + " " + human.getSurname());
            number++;
        }

        System.out.println("Select number:");
        Integer chosenUserId = scanner.nextInt() - 1;
        currentHuman = humans.get(chosenUserId);
    }
}
