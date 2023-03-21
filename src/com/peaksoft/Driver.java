package com.peaksoft;

import static com.peaksoft.Main.GSON;

public class Driver {
    private int id;
    private String name;
    private String truckName;

    public static Driver creatDriver(int id, String name, String truckName) {
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truckName = truckName;
        return driver;
    }

    public static void driverTab(String gson) {
        Driver[] drivers = GSON.fromJson(gson, Driver[].class);
        System.out.println("#  |  Driver  | Truck ");
        System.out.println("---*----------*--------");

        for (Driver driver : drivers) {
            System.out.println(driver.id + "   " + driver);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    @Override
    public String toString() {
        return "" + name;
    }

    public String infoDriving() {
        return "" + id + "  | " + name + "  | ";
    }
}
