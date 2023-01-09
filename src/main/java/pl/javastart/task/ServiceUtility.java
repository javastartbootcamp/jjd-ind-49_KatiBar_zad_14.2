package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ServiceUtility {
    private static final int EXIT = 0;
    private static final int ADD_CAR = 1;
    private static final int POLL_CAR = 2;
    private Queue<Car> cars = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public Queue<Car> getCarsQueueFromFile(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                String type = split[0];
                String make = split[1];
                String model = split[2];
                int productionYear = Integer.parseInt(split[3]);
                int mileage = Integer.parseInt(split[4]);
                String vin = split[5];
                Car car = new Car(type, make, model, productionYear, mileage, vin);
                cars.add(car);
            }
        }
        return cars;
    }

    public void run(String fileName) throws IOException {
        cars = getCarsQueueFromFile(fileName);
        int option;
        do {
            option = chooseOption();
            switch (option) {
                case EXIT:
                    exit(fileName);
                    break;
                case ADD_CAR:
                    cars.add(createCar());
                    break;
                case POLL_CAR:
                    poolCar();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wybierz ponownie.");
            }
        } while (option != EXIT);
    }

    private void poolCar() {
        if (!cars.isEmpty()) {
            System.out.println(cars.poll() + " w trakcie przeglądu.");
        } else {
            System.out.println("Brak pojazdów w kolejce");
        }
    }

    private void exit(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!cars.isEmpty()) {
            saveToFile(fileName, cars);
        }
        System.out.println("Program zakończony.");
    }

    private void saveToFile(String fileName, Queue<Car> cars) throws IOException {
        try (var fileWriter = new FileWriter(fileName);
             var bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Car car : cars) {
                String carToCsv = car.toCsv();
                bufferedWriter.write(carToCsv);
                bufferedWriter.newLine();
            }
        }
    }

    private int chooseOption() {
        printOptions();
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private static void printOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(EXIT + " - zakończ program");
        System.out.println(ADD_CAR + " - dodaj nowy pojazd");
        System.out.println(POLL_CAR + " - pobierz pojazd z kolejki do przeglądu");
    }

    private Car createCar() {
        System.out.println("Podaj typ pojazdu:");
        String type = scanner.nextLine();
        System.out.println("Podaj markę:");
        String make = scanner.nextLine();
        System.out.println("Podaj model:");
        String model = scanner.nextLine();
        System.out.println("Podaj rok produkcji:");
        int productionYear = scanner.nextInt();
        System.out.println("Podaj przebieg:");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj numer VIN:");
        String vin = scanner.nextLine();
        return new Car(type, make, model, productionYear, mileage, vin);
    }
}
