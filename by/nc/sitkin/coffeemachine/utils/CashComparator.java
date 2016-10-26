package by.nc.sitkin.coffeemachine.utils;

import by.nc.sitkin.coffeemachine.entities.Cash;

import java.util.Comparator;

/**
 * Created by upsit on 16-Oct-16.
 */
class CashComparator implements Comparator<Cash>{
    @Override
    public int compare(Cash cash1, Cash cash2){
        double money1 = cash1.getDollars() + (double)(cash1.getCents() / 100) ;
        double money2 = cash2.getDollars() + (double)(cash2.getCents() / 100) ;
        if (money1 > money2){
            return 1;
        }
        else if (money1 < money2){
            return -1;
        }
        return 0;
    }
}
