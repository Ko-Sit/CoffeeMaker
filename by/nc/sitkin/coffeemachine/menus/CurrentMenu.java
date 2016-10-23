package by.nc.sitkin.coffeemachine.menus;

import by.nc.sitkin.coffeemachine.commands.*;
import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.CoffeeMachine;
import by.nc.sitkin.coffeemachine.entities.Human;
import by.nc.sitkin.coffeemachine.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by upsit on 22-Oct-16.
 */
public class CurrentMenu {
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setDefaultMenu(String startMenuDescription[], List<Human> humans, CoffeeMachine coffeeMachine) {
        Menu startMenu = new Menu(startMenuDescription);
        startMenu.setCommand("create user", new CreateUserCommand(humans));
        startMenu.setCommand("create admin", new CreateAdminCommand(humans, coffeeMachine));
        startMenu.setCommand("change human", new ChangeHumanCommand(humans));
        startMenu.setCommand("exit", new ExitCommand());
        this.menu = startMenu;
    }

    public void setUserMenu(String userMenuDescription[], User user, CoffeeMachine coffeeMachine){
        Menu userMenu = new Menu(userMenuDescription);
        userMenu.setCommand("select drink", new SelectDrinkCommand(coffeeMachine));
        userMenu.setCommand("pay money", new PayMoneyCommand(user));
        userMenu.setCommand("back", new BackCommand());
        this.menu = userMenu;
    }

    public void setAdminMenu(String adminMenuDescription[], Admin admin){
        Menu adminMenu = new Menu(adminMenuDescription);
        adminMenu.setCommand("fill machine", new FillMachineCommand(admin));
        adminMenu.setCommand("back", new BackCommand());
        this.menu = adminMenu;
    }




}
