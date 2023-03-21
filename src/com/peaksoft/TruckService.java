package com.peaksoft;

import java.util.Random;
import java.util.Scanner;

import static com.peaksoft.Main.GSON;

public class TruckService {
    static String dr;
    static String driverName;
    static String truckName;
    static Scanner scan = new Scanner(System.in);
    static Driver driver = new Driver();
    static Random random = new Random();


    public static void changeTruck(Truck[] trucks, Driver[] drivers1, int id) {
        for (Truck truck : trucks) {
            if (truck.getDriver().getName() == null){
                truck.getDriver().setName("    ");
            }
            truck.getDriver().setName("  ");
            if (truck.getId() == id) {
                System.out.println("------------------------------------");
                System.out.println();
                if (truck.getStatus().equals(Status.BASE)) {
                    System.out.println("Выброно грузовик " + truck.getName());
                    System.out.println("Для топравки в путь нажмите     1");
                    System.out.println("Для отправки в ремонт нажмите   2");
                    System.out.println("Для выбора водителя нажмите     3");
                    System.out.println("\n---------------------------------------");
                    System.out.println();
                    int change = scan.nextInt();
                    if (change == 1) {
                        randomDriver(drivers1);
                        truck.setStatus(Status.ROUTE);
                        truck.setDriver(driver);
                        startDriving(truck.getName(), driver.getName());
                        System.out.println("-----------------------------------");
                    }
                    if (change == 2) {
                        truck.setStatus(Status.REPAIR);
                        startRepairing(truck.getName(), truck.getDriver().getName());
                        System.out.println(truck.getStatus());
                        System.out.println("-----------------------------------");
                    }
                    if (change == 3) {
                        Driver.driverTab(GSON.toJson(drivers1));
                        truck.setDriver(driver);
                        truck.setStatus(Status.ROUTE);
                        int change2 = scan.nextInt();
                        for (Driver driver1 : drivers1) {
                            if (driver1.getId() == change2) {
                                driver = driver1;
                            }
                        }
                        System.out.println("#  |  Driver  | Truck ");
                        System.out.println("---*----------*--------");
                        System.out.println("   " + driverName +  "   " + truck.getName());
                    }
                }
            }
        }
    }

    public static void startDriving(String truckName, String driverName) {
        System.out.println("#  |   Truck   |   Driver   | Status");
        System.out.println("---*-----------*-----------*--------");
        System.out.println("    " + truckName + "      " + driverName);
    }

    public static void startRepairing(String truckName, String driverName) {
        System.out.println("#  |   Truck   |   Driver   | Status");
        System.out.println("---*-----------*-----------*--------");
        System.out.println("Truck " + truckName + " driver " + driverName);
    }

    public static void randomDriver(Driver[] drivers1) {
        int d = random.nextInt(3) + 1;
        for (Driver driver1 : drivers1) {
            if (driver1.getId() == d) {
                driverName = driver1.getName();
                driver = driver1;
            }
        }
    }

}
