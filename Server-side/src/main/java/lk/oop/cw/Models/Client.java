package lk.oop.cw.Models;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client{

    private WestminsterRentalVehicleManager wrm = new WestminsterRentalVehicleManager();
    public  void addNewVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the vehicle type : ");
        while (!sc.hasNext()) {
            System.out.print("Vehicle type is incorrect!");
            sc.next();
        }
        String vehicleType = sc.next().toLowerCase();
        while (!vehicleType.equals("car") && !vehicleType.equals("motorbike")) {
            System.out.print("Wrong ! Please enter correct vehicle type :");
            vehicleType = sc.next();
        }
        System.out.print("Enter plate number :");
        String plateNum = sc.next();

        System.out.print("Enter vehicle make : ");
        String make = sc.next();

        System.out.print("Enter vehicle model : ");
        String model = sc.next();
        boolean isNumeric = false;
        int numOfSeats = 0;
        while (!isNumeric) {
            try {
                System.out.print("Enter vehicle's number of seats : ");
                numOfSeats = sc.nextInt();
                isNumeric = true;
            } catch (InputMismatchException exception) {
                System.out.print("Invalid character found,Enter only numeric values!");
                sc.nextLine();
            }
        }
        System.out.print("Is vehicle available(true/false) : ");
        while (!sc.hasNextBoolean()) {
            System.out.print("Not found!Enter either true or false :");
            sc.next();
        }
        boolean availability = sc.nextBoolean();

        System.out.print("Enter priceRate(per day) : ");
        while (!sc.hasNextBigDecimal()) {
            System.out.print("Wrong input!Enter correct value :");
            sc.next();
        }
        BigDecimal priceRate = sc.nextBigDecimal();

        System.out.print("Enter type of transmission : ");
        while (!sc.hasNext()) {
            System.out.print("Invalid value! Enter correct value :");
            sc.next();
        }
        String transmission = sc.next();
        while (!transmission.equals("auto") && !transmission.equals("manual")) {
            System.out.print("The transmission can be either auto or manual! Enter again :");
            transmission = sc.next();

        }
        boolean acAvailability = false;
        String color =null;
        int numOfDoors =0;
        Vehicle vh;
        if (vehicleType.equals("car")) {
            System.out.print("Is A/C available(true/false) : ");
            acAvailability = sc.nextBoolean();
            while(!acAvailability){
                System.out.println("Wrong input!!! Enter :");
                acAvailability =sc.nextBoolean();
            }
            System.out.print("Enter car color : ");
            color = sc.next();
            System.out.print("Enter number of Doors: ");
            numOfDoors= sc.nextInt();
            vh = new Car(plateNum, make, model, numOfSeats, availability, priceRate, acAvailability, color, transmission, numOfDoors);

        }else {
            System.out.print("Enter seatHeight : ");
            double seatHeight = sc.nextDouble();
            System.out.print("Enter tank capacity(CC): ");
            int tankCapacity = sc.nextInt();
            System.out.print("Enter luggage weight : ");
            double luggageWeight = sc.nextDouble();
            vh=new MotorBike(plateNum,make,model,numOfSeats,availability,transmission,priceRate,seatHeight,tankCapacity,luggageWeight);
        }

        wrm.addNewVehicle(vh);
    }

    public  void deleteVehicle(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter plate Number : ");
        String plateNum =sc.next();
        wrm.deleteVehicle(plateNum);

    }
    public static void main(String[] args){
        Client cl = new Client();
        cl.wrm.initialise();
        // Menu console

        System.out.println("---WELCOME TO WESTMINSTER VEHICLE RENTAL!---");
        while(true) {
            System.out.println("Select below options :");
            System.out.println("1 - Add vehicle to a system");
            System.out.println("2 - Delete a vehicle from the system");
            System.out.println("3 - Print list of all the vehicles");
            System.out.println("4 - Write/save to the file");
            System.out.println("5 - Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the option :");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("------ADD A VEHICLE---");
                    char cont = 'y';
                    while (cont == 'y') {

                        cl.addNewVehicle();
                        System.out.print("Do you want to continue(y/n)?");
                        cont = sc.next().toLowerCase().charAt(0);
                    }
                    break;
                case 2:
                    System.out.println("------DELETE VEHICLE-----");
                    cl.deleteVehicle();
                    break;
                case 3:
                    System.out.println("------LIST OF ALL THE VEHICLES-----");
                    cl.wrm.printListOfVehicle();
                    break;
                case 4:
                    System.out.println("------WRITE/SAVE-----");
                    cl.wrm.writeOrSave();
                    break;
                case 5:
                    System.out.println("------HAVE A NICE DAY-----");
                    System.exit(0);
                default:
                    System.out.println("You have entered invalid option!");
            }

        }
    }
}