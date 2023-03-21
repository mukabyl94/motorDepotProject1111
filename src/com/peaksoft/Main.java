package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static String GSON_WRITE = "./truck.gson";
    public static String GSON_WRITE2 = "./driver.gson";


    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.creatTruck(1, "Renault", new Driver(), Status.BASE),
                Truck.creatTruck(2, "Volvo  ", new Driver(), Status.BASE),
                Truck.creatTruck(3, "DAF XT ", new Driver(), Status.BASE),
        };
        Driver[] drivers = {
                Driver.creatDriver(1, " Tom   ", " "),
                Driver.creatDriver(2, " Jerry ", " "),
                Driver.creatDriver(3, " Mick  ", " "),
        };
        String gsonTruck = GSON.toJson(trucks);
        String gsonDriver = GSON.toJson(drivers);
//        write(gsonTruck,GSON_WRITE);
//        write(gsonDriver,GSON_WRITE2);
//        read(GSON_WRITE);
//        read(GSON_WRITE2);
        Truck.truckTab(gsonTruck);
        System.out.println();
        Driver.driverTab(gsonDriver);

        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("\nВыберите грузовика: ");
                int change = scan.nextInt();
                TruckService.changeTruck(trucks, drivers, change);
                System.out.println("#  |   Truck   |   Driver   | Status");
                System.out.println("---*-----------*-----------*--------");
                for (Truck truck : trucks){

                    if (truck.getDriver().getName() == null){
                        System.out.println(truck.getId() + "   " + truck.getName()+"     "+"      "+"    "+
                                truck.getStatus());
                    }else{
                        System.out.println(truck.getId() + "   "+ truck.getName()+ "    " + truck.getDriver().getName()+
                                "         "+truck.getStatus());
                    }
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }




    }

    public static void write(String gson, String var) {
        Path path = Paths.get(var);
        try {
            Files.writeString(path, gson, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void read(String var) {
        try {
            FileReader fileReader = new FileReader(var);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}