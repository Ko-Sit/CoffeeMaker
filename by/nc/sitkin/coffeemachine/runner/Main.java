//package by.nc.sitkin.coffeemachine.runner;
//
//import by.nc.sitkin.coffeemachine.entities.*;
//import by.nc.sitkin.coffeemachine.exceptions.InvalidValueException;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//
//    public enum Menu {
//        MAIN, USER, ADMIN, DRINK
//    }
//
//    private static void printMenu(HashMap<Integer, String> map) {
//        for (Map.Entry<Integer, String> entry : map.entrySet()){
//            System.out.println(entry.getKey() + ". " + entry.getValue() );
//        }
//        System.out.println("---------------------");
//    }
//
//    // TODO: 17-Oct-16 use ListIterator and GregorianCalendar
//    public static void main(String[] args){
//        ArrayList<Human> humans = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//
//        CoffeeMachine coffeeMachine = new CoffeeMachine();
//
//        HashMap<Integer, String> mainMap = new HashMap<>();
//        mainMap.put(1, "Create User");
//        mainMap.put(2, "Create Admin");
//        mainMap.put(3, "Change Human");
//        printMenu(mainMap);
//        HashMap<Integer, String> userMap = new HashMap<>();
//        userMap.put(1, "Select drink");
//        userMap.put(2, "Pay money");
//        //printMenu(userMap);
//        HashMap<Integer, String> adminMap = new HashMap<>();
//        adminMap.put(1, "Fill coffeemachine");
//        //printMenu(adminMap);
//        HashMap<Integer, String> drinkMap = new HashMap<>();
//        drinkMap.put(1, "coffee");
//        drinkMap.put(2, "coffee + sugar");
//        drinkMap.put(3, "coffee + milk");
//        drinkMap.put(4, "coffee + sugar + milk");
//        //printMenu(drinkMap);
//
//        Menu currentMenu = Menu.MAIN;
//
//        String name;
//        String surname;
//        System.out.println("Name:");
//        name = scanner.next();
//        System.out.println("Surname:");
//        surname = scanner.next();
//        humans.add(new Admin(name, surname, coffeeMachine));
//
//
//
//    }
//}
