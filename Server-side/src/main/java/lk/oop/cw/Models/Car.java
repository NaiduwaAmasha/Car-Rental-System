
package lk.oop.cw.Models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle{

    private boolean acAvailability;
    private String color;
    private int numOfDoors;

    public Car(){
        super();
        this.acAvailability = false;
        this.color = null;
        this.numOfDoors = 0;
    }
    public Car(boolean acAvailability,String color,int numOfDoors){
        super();
        this.acAvailability = acAvailability;
        setColor(color);
        setNumOfDoors(numOfDoors);
    }

    public Car(String plateNum, String make, String model, int numSeats, boolean availability, BigDecimal priceRate,boolean acAvailability,String color,String transmission,int numOfDoors){
        super(plateNum,make,model,numSeats,availability,transmission,priceRate);
        this.acAvailability =acAvailability;
        setColor(color); // this.color =color;
        setNumOfDoors(numOfDoors); //this.numOfDoors = numOfDoors;

    }

    //---getters and setters relative to the instance variables-----

    public boolean isAcAvailability() {
        return acAvailability;
    }

    public void setAcAvailability(boolean acAvailability) {
        this.acAvailability = acAvailability;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color !=null) {
            try {
                this.color = color;
            }catch (NumberFormatException exception){
                throw new IllegalArgumentException("Not a number! Try again");
            }
        }else{
            throw new IllegalArgumentException("Color cannot be null!");
        }
    }


    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        if(numOfDoors>0 && numOfDoors<=5) {
            this.numOfDoors = numOfDoors;
        }else{
            throw new IllegalArgumentException("Please enter right amount of car doors!");
        }
    }

    @Override
    public void setNumOfSeats(int numSeats) {
        if(numSeats > 0){
            this.numSeats =numSeats;
        }else{
            throw new IllegalArgumentException("Num of seats in a car cannot zero or negative!");
        }
    }

    @Override
    public String toString() {
        return "Car["+super.toString()+"\n\tA/C available : "+isAcAvailability() +"\n\tColor : "+getColor()
                +"\n\tNum of Doors : "+getNumOfDoors()+"\n]";
    }



}
