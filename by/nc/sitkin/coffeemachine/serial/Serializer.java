package by.nc.sitkin.coffeemachine.serial;

import by.nc.sitkin.coffeemachine.entities.Admin;
import by.nc.sitkin.coffeemachine.entities.Person;

import java.io.*;

/**
 * Created by upsit on 22-Oct-16.
 */
public class Serializer {
    private String filePath = "C:\\Users\\upsit\\IdeaProjects\\CoffeeMaker\\" +
            "src\\by\\nc\\sitkin\\coffeemachine\\files\\input\\";
    private String fileName = "serializedAdmin.txt";

    public void serialize(Person person) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath + fileName);
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
            FileInputStream fis = new FileInputStream(filePath + fileName);
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


