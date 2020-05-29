
package lk.oop.cw.Models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "VEHICLE_TYPE",
        columnDefinition = "VARCHAR(20)"
)


public abstract class Vehicle implements Comparable<Vehicle>{
    @Column(name="VEHICLE_TYPE",insertable = false,updatable = false)
    String VEHICLE_TYPE;
    @Id
    protected String plateNum;
    protected String make;
    protected String model;
    protected int numSeats;
    protected boolean availability;
    protected String transmission;
    protected BigDecimal priceRate;

    public Vehicle(){
        this.plateNum = null;
        this.make = null;
        this.model = null;
        this.numSeats = 0;
        this.availability = false;
        this.transmission = null;
        this.priceRate = BigDecimal.valueOf(0.0);
    }
    public Vehicle(String plateNum,String make,String model,int numSeats,boolean availability,String transmission,BigDecimal priceRate){
       setPlateNum(plateNum); // this.plateNum = plateNum;
        setMake(make); //this.make = make;
        setModel(model); //this.model = model;
        setNumOfSeats(numSeats); //this.numSeats =numSeats;
        this.availability =availability;
        this.transmission =transmission;
        setPriceRate(priceRate); //this.priceRate = priceRate;
    }
    public String getVEHICLE_TYPE() {
        return VEHICLE_TYPE;
    }

    public void setVEHICLE_TYPE(String VEHICLE_TYPE) {
        this.VEHICLE_TYPE = VEHICLE_TYPE;
    }
    public void setPlateNum(String plateNum){
        if(plateNum != null) {
            this.plateNum = plateNum;
        }else{
            throw new IllegalArgumentException("license plate number cannot be null!");
        }
    }

    public String getPlateNum(){
        return this.plateNum;
    }


    public void setMake(String make) {
        if(make != null) {
            this.make = make;
        }else{
            throw new IllegalArgumentException("Make cannot be null!");
        }
    }

    public String getMake(){
        return this.make;
    }


    public void setModel(String model){
        if(model !=null) {
            this.model = model;
        }else{
            throw new IllegalArgumentException("Model cannot be null!");
        }
    }
    public String getModel(){
        return this.model;
    }

    //abstract method because the max number of seats depend on the vehicle type
    public abstract void setNumOfSeats(int numSeats);

    public int getNumOfSeats(){
        return this.numSeats;
    }

    public void setAvailability(boolean availability){
        this.availability = availability;
    }

    public boolean getAvailability(){
        return this.availability;
    }

    public void setPriceRate(BigDecimal priceRate){
        BigDecimal bg =new BigDecimal("0.0");
        if(priceRate.compareTo(bg) > 0) {
            this.priceRate = priceRate;
        }else{
            throw new IllegalArgumentException("Price rate cannot be negative");
        }
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public BigDecimal getPriceRate(){
        return this.priceRate;
    }

    @Override
    public String toString() {
        return "Vehicle[ PlateNum :"+getPlateNum()+" ,Make : "+getMake()+" ,Model : "+getModel()
        +" ,Num Of Seats : "+getNumOfSeats()+" , Availability : "+getAvailability()+" ,PriceRate : "+getPriceRate()+" ,Transmission : "+getTransmission()+"]";
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return (this.make.charAt(0) - vehicle.make.charAt(0));
    }
}
