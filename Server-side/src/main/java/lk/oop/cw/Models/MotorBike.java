package lk.oop.cw.Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("MotorBike")
public class MotorBike extends Vehicle{

    private double seatHeight;
    private int tankCapacity;
    private double luggageWeight;

    public MotorBike(){
        super();
        this.seatHeight=0.0;
        this.tankCapacity = 0;
        this.luggageWeight =0.0 ;
    }
    public  MotorBike(double seatHeight,int tankCapacity,double luggageWeight){
        super();
        setSeatHeight(seatHeight);
        setTankCapacity(tankCapacity);
        this.luggageWeight =luggageWeight;
    }
    MotorBike(String plateNum, String make, String model, int numSeats, boolean availability,String transmission, BigDecimal priceRate,double seatHeight,int tankCapacity,double luggageWeight){
        super(plateNum, make, model, numSeats,availability,transmission,priceRate);
        setSeatHeight(seatHeight);
        setTankCapacity(tankCapacity);
        this.luggageWeight = luggageWeight;
    }

    public double getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(double seatHeight) {
        if(seatHeight>0){
            this.seatHeight = seatHeight;
        }else{
            throw new IllegalArgumentException("SeatHeight must be positive!");
        }
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        if(tankCapacity>0) {
            this.tankCapacity = tankCapacity;
        }else{
            throw new IllegalArgumentException("Tank capacity shouldn't be negative");
        }
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    @Override
    public void setNumOfSeats(int numSeats) {
        if(numSeats <= 2 && numSeats > 0){
            this.numSeats =numSeats;
        }else{
            throw new IllegalArgumentException("Num of seats in a car cannot be more than 5");
        }
    }

    @Override
    public String toString() {
        return "Motor Bike["+super.toString()+"\n\tSeat Height : " +getSeatHeight()+"\n\tTank Capacity : "+getTankCapacity()
                +"\n\tLuggage Weight :"+getLuggageWeight()+"\n]";
    }
}
