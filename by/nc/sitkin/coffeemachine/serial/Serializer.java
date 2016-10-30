package by.nc.sitkin.coffeemachine.serial;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.Person;

import java.io.*;

/**
 * Created by upsit on 22-Oct-16.
 */
public class Serializer {

    public void serialize(Person person) {
        try {
            FileOutputStream fos = new FileOutputStream("myfile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            System.out.println("serialising problem was detected..");
        }
    }

    public Person deserialize() {
        Person person;
        try {
            FileInputStream fis = new FileInputStream("myfile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            person = (Admin) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            return new Admin();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            return new Admin();
        }
        return person;
    }
}


