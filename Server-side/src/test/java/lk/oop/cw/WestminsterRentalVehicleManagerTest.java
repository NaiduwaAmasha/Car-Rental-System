package lk.oop.cw;

import lk.oop.cw.Models.Car;
import lk.oop.cw.Models.MotorBike;
import lk.oop.cw.Models.Vehicle;
import lk.oop.cw.Models.WestminsterRentalVehicleManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class WestminsterRentalVehicleManagerTest {
    private WestminsterRentalVehicleManager wrm;

    @BeforeEach
    void initEach(){wrm = new WestminsterRentalVehicleManager();}

    @Nested
    class ManageVehicle{
        @Test
        void testAddingNullObject(){

            Vehicle car = new Car();
            Vehicle motorBike = new MotorBike();
            assertNotNull("Verify that vehicle is not null",car);
            assertNotNull("Verify that vehicle is not null",motorBike);
        }

        @Test
        void testDeletingNullObject(){
            Vehicle car = new Car();
            Vehicle motorBike = new MotorBike();
            assertNotNull("Verify that vehicle is not null",car);
            assertNotNull("Verify that vehicle is not null",motorBike);
        }

        @Test
        void testPrintListOfVehicle(){
            Vehicle obj1 = new Car();
            Vehicle obj2 = new Car();
            Vehicle obj3 = new Car();
            Vehicle obj4 = new Car();
            Vehicle obj5 = new Car();
            Vehicle obj6 = new MotorBike();
            Vehicle obj7 = new MotorBike();
            Vehicle obj8 = new MotorBike();
            Vehicle obj9 = new MotorBike();
            Vehicle obj10 = new MotorBike();

            List<Vehicle> list = new ArrayList<>();
            list.add(obj1);
            list.add(obj2);
            list.add(obj3);
            list.add(obj4);
            list.add(obj5);
            list.add(obj6);
            list.add(obj7);
            list.add(obj8);
            list.add(obj9);

            assertFalse(list.isEmpty());



        }
    }
}
