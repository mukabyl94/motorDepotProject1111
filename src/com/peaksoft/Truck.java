package com.peaksoft;

import static com.peaksoft.Main.GSON;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private Status status;
    public static Truck creatTruck(int id, String name, Driver driver, Status status){
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.status = status;
        return truck;
    }
    public static void truckTab(String gson){
        Truck[] trucks = GSON.fromJson(gson, Truck[].class);
        System.out.println("#  |   Truck   |   Driver   | Status");
        System.out.println("---*-----------*-----------*--------");
        for (Truck truck : trucks) {
            System.out.println(truck);
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "" + id + "    " + name + "   " + driver + "              " + status;
    }
}
