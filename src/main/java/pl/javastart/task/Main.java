package pl.javastart.task;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fileName = "CarsQueue.csv";
        ServiceUtility serviceUtility = new ServiceUtility();
        try {
            serviceUtility.run(fileName);
        } catch (IOException e) {
            System.out.println("Sprawdź, czy podałeś poprawną nazwę pliku: " + fileName);
        }
    }
}
