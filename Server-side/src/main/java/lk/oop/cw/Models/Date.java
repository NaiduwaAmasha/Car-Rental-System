package lk.oop.cw.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Date {

    @Id private int id;
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>0) {
            this.year = year;
        }else{
            throw new IllegalArgumentException("Year cannot be negative number!");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month>=1 && month<=12) {
            this.month = month;
        }else{
            throw new IllegalArgumentException("Month should be between 1 and 12");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day > 0) {
            this.day = day;
        }else{
            throw new IllegalArgumentException("Day cannot be negative!");
        }
    }
}
