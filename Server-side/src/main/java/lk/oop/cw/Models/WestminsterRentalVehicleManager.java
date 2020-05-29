package lk.oop.cw.Models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    private final static int MAX_PARKING_SLOT = 50;
    private List dbReords = new ArrayList();
    private List<Vehicle> allVehicleList = new ArrayList<>();

    public void initialise() {
        Database db = new Database();
        dbReords = db.getList();

    }
    public void addNewVehicle(Vehicle vehicle) {

        /*
         * Should find the number of vehicles in the database
         * calculate available space
         * show error message if the space is not enough
         * takes details of the vehicle
         * add to the database
         */

        if (dbReords.size() < MAX_PARKING_SLOT) {
            allVehicleList.add(vehicle);
        } else {
            System.out.println("There is no space available in the list");
        }
    }

    public void deleteVehicle(String plateNum) {
        //Gets the vehicle type and plate number
        boolean found = false;
        String typeOfVehicle = null;

        if (allVehicleList == null) {
            System.out.println("There is no vehicles added to the system to delete yet!");
        }

        for (Vehicle vehicle : allVehicleList) {
            if (vehicle.getPlateNum().equals(plateNum)) {

                allVehicleList.remove(vehicle);
                typeOfVehicle = vehicle instanceof Car ? "Car" : "MotorBike";
                System.out.println("Type of vehicle deleted from the list is  a " + typeOfVehicle);
                break;


            } else {
                System.out.println("Vehicle is not found on the list!");
            }
            int availableSpaces = MAX_PARKING_SLOT - allVehicleList.size() - dbReords.size();
            System.out.println("Available free space : " + availableSpaces);
        }

    }

    //prints list of vehicles
    //the make of the vehicles has been sorted in the alphabetical order
    public void printListOfVehicle() {
        String typeOfVehcile = null;

        //If the list is null
        if (allVehicleList == null) {
            System.out.println("There is no vehicles added to the system yet!");
        }
        Collections.sort(allVehicleList);
        for (Vehicle vehicle : allVehicleList) {
            typeOfVehcile = vehicle instanceof Car ? "Car" : "MotorBike";
            System.out.println("PlateNum : " + vehicle.getPlateNum() + " ,Type : " + typeOfVehcile + " ,make : " + vehicle.getMake());
        }
    }

    public void writeOrSave() {
        File file = new File("VehicleRentalReport.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw, true);
            for (Vehicle obj : allVehicleList) {
                pw.println(obj);
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Database db = new Database();
        db.addList(allVehicleList);
        System.out.println("Successfully generated!");
        System.out.println("--------------------------------------");
    }


}
