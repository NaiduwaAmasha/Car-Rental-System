package lk.oop.cw.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="scheduleNo")
    private int scheduleNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date pickUpDate;

    @JoinColumn(name="dropOffDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dropOffDate;

    @Column(name="pickUpLocation")
    private String pickUpLocation;

    @Column(name="orderStatus")
    private String orderStatus;

    @Column(name="returnLocation")
    private String returnLocation;

    private BigDecimal deposit;

    @OneToOne(targetEntity = Vehicle.class)
    @JoinColumn(name="plateNum")
    private Vehicle vehicle;

    @OneToOne(targetEntity = Customer.class)
    @JoinColumn(name="NIC_No")
    private Customer customer;


    public Schedule(){
        this.pickUpDate = null;
        this.dropOffDate = null;
        this.pickUpLocation = null;
        this.returnLocation = null;
        this.deposit = null;
        this.vehicle = null;
        this.customer = null;
    }

    public Schedule(Date pickUpDate, Date dropOffDate, String pickUpLocation, String returnLocation, BigDecimal deposit, Vehicle vehicle, Customer customer) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.deposit = deposit;
        this.vehicle = vehicle;
        this.customer = customer;
    }

    //Represent the time slot the vehicle is rented and time slot is calculated by day per se
    public int calculateDuration(Date pickUpDate,Date dropOffDate){
        if(pickUpDate.getMonth() == 1 || pickUpDate.getMonth() == 3 || pickUpDate.getMonth() == 5 || pickUpDate.getMonth() == 7 || pickUpDate.getMonth() == 8 || pickUpDate.getMonth() == 10 || pickUpDate.getMonth() == 12 ) {
            return (dropOffDate.getDay() - pickUpDate.getDay()) % 31;
        }else if(pickUpDate.getMonth() == 4 || pickUpDate.getMonth()==6 || pickUpDate.getMonth() == 9 || pickUpDate.getMonth() == 11){
            return (dropOffDate.getDay() - pickUpDate.getDay()) % 30;
        }else if( pickUpDate.getMonth() == 2){
            return (dropOffDate.getDay() - pickUpDate.getDay()) % 28;
        }
        throw new IllegalArgumentException("Couldn't calculate the duration!");
    }

    //--getter and setters relative to attributes----
    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
