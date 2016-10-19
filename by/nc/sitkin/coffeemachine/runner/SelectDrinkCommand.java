package by.nc.sitkin.coffeemachine.runner;

import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;

import java.util.Scanner;

public class SelectDrinkCommand implements Command {
    private CoffeeMachine coffeeMachine;

    public SelectDrinkCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.coffee");
        System.out.println("2.coffee + sugar");
        System.out.println("3.coffee + milk");
        System.out.println("-----------------");
        System.out.println("Input number:");
        int chosenDrink = scanner.nextInt();
        // TODO: 19-Oct-16 выбор напитка и возврат
        coffeeMachine.produceItem();

    }
}
