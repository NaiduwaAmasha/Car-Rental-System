package lk.oop.cw.Models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class Database {

    private static List<Vehicle> allVehicle = new ArrayList<Vehicle>();

    public  List<Vehicle> getList(){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List query = session.createQuery("from Vehicle").list();

        for(Iterator iterator = query.iterator();iterator.hasNext();){
            allVehicle.add((Vehicle) iterator.next());
        }
        //is possible with hibernate
        //sorts in alphabetical order
        session.getTransaction().commit();
        session.close();
        System.out.println(allVehicle);
        return allVehicle;
    }

    public  void addList(List<Vehicle> stockList) {
        String type = null;

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        for (Vehicle obj : stockList) {
            type = obj instanceof Car? "Car" : "MotorBike";
            if (type.equals("Car")) {
                Car car = new Car();
                car = (Car) obj;
                session.save(car);
            } else {
                MotorBike motorBike = new MotorBike();
                motorBike = (MotorBike) obj;
                session.save(motorBike);
            }
        }
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
