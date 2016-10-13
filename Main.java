import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Cash cash = new Cash();
        System.out.println(cash.equals(new Cash()));
        System.out.println(cash.hashCode());
        System.out.println(cash.toString());
        Human human = new Human();
        System.out.println(human.equals(new Human()));
        System.out.println(human.hashCode());
        System.out.println(human.toString());
        User user = new User();
        System.out.println(user.equals(new Admin()));
        System.out.println(user.hashCode());
        System.out.println(user.toString());
        Admin admin = new Admin();
        System.out.println(admin.equals(new Admin()));
        System.out.println(admin.hashCode());
        System.out.println(admin.toString());
        ArrayList<Cash> lst = new ArrayList<>();
        lst.add(new Cash());
        lst.add(new Cash());
        lst.add(new Cash());
        ArrayList<Cash> lst1 = new ArrayList<>();
        lst1.add(new Cash());
        lst1.add(new Cash());
        lst1.add(new Cash());
        System.out.println(lst.equals(lst1));
        System.out.println(lst1.equals(lst));
        System.out.println(lst.hashCode());
    }
}
