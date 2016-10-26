package by.nc.sitkin.coffeemachine.utils;

import by.nc.sitkin.coffeemachine.entities.User;

import java.util.Comparator;

/**
 * Created by upsit on 16-Oct-16.
 */
public class UserComparator implements Comparator<User>{
    @Override
    public int compare(User user1, User user2) {
        if (user1.getName().compareTo(user2.getName()) > 0){
            return 1;
        }
        else if (user1.getName().compareTo(user2.getName()) < 0){
            return -1;
        }
        else if (user1.getSurname().compareTo(user2.getSurname()) > 0){
            return 1;
        }
        else if (user1.getSurname().compareTo(user2.getSurname()) < 0){
            return -1;
        }
        return 0;
    }
}
