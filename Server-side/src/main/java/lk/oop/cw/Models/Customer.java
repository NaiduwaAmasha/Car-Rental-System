package lk.oop.cw.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
public class Customer{
    @Id
    private int cusNICNo; // modern NIC NO with only integers
    private String cusFirstName;
    private String cusLastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cusDOB;
    private boolean licenseAvailability;
    private boolean periodOfLicenseOwnership ;
    private String phoneNo;


    private String cardHolderName;
    private int cardNo;
    private int ccv_code;


    public Customer(){}

    public Customer(int cusNICNo, String cusFirstName, String cusLastName, Date cusDOB, boolean licenseAvailability, boolean periodOfLicenseOwnership) {
        this.cusNICNo = cusNICNo;
        this.cusFirstName = cusFirstName;
        this.cusLastName = cusLastName;
        this.cusDOB = cusDOB;
        this.licenseAvailability = licenseAvailability;
        this.periodOfLicenseOwnership = periodOfLicenseOwnership;
    }

    //calculates user's age using user's date of birth and current year
    public int calculateAge(Date cusDOB){
        LocalDate now = LocalDate.now();
        LocalDate dob = LocalDate.of(cusDOB.getYear(),cusDOB.getMonth(),cusDOB.getDay());
        if((cusDOB != null) && (now!= null)){
            return Period.between(dob,now).getDays();
        }else{
            return 0;
        }
    }

    //One of the requirement to rent the car
    public boolean isSuitableToDrive(int periodOfLicenseOwnership){
        boolean requirement = isLicenseAvailability();
        //user must have at least 1 year of experience of driving
        return requirement && periodOfLicenseOwnership>1;

    }

    //returns the full name of the customer
    public String getFullName(){
        return getCusFirstName() + getCusLastName();
    }


    //-----getters and setters relative to attributes
    public int getCusNICNo() {
        return cusNICNo;
    }

    public void setCusNICNo(int cusNICNo) {
        this.cusNICNo = cusNICNo;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public Date getCusDOB() {
        return cusDOB;
    }

    public void setCusDOB(Date cusDOB) {
        this.cusDOB = cusDOB;
    }

    public boolean isLicenseAvailability() {
        return licenseAvailability;
    }

    public void setLicenseAvailability(boolean licenseAvailability) {
        this.licenseAvailability = licenseAvailability;
    }

    public boolean getPeriodOfLicenseOwnership() {
        return periodOfLicenseOwnership;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCcv_code() {
        return ccv_code;
    }

    public void setCcv_code(int ccv_code) {
        this.ccv_code = ccv_code;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPeriodOfLicenseOwnership(boolean periodOfLicenseOwnership) {
        this.periodOfLicenseOwnership = periodOfLicenseOwnership;
    }
}
