package by.nc.sitkin.coffeemachine.runner;

import java.util.Scanner;

public class Client {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        menu.setCommand("create user", new CreateUserCommand());
        menu.setCommand("create admin", new CreateAdminCommand());
        menu.setCommand("change human", new ChangeHuman());

        menu.runCommand("create user");
        menu.runCommand("create admin");
        menu.runCommand("change human");
        System.out.println("Your command now:");
        String command = scanner.nextLine();
        menu.runCommand(command);

    }
}
