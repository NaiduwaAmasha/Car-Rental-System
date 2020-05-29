package lk.oop.cw;
import static org.junit.jupiter.api.Assertions.*;

import lk.oop.cw.Models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void initEach(){
        car = new Car(true,"Red",4);
    }
    @Nested
    class testCar{

        @Test
        void testACAvailabilty(){
            assertAll(
                    ()->assertEquals(true,car.isAcAvailability()),
                    ()->assertEquals(false,car.isAcAvailability()),
                    ()->assertEquals("true",car.isAcAvailability(),"isAcAvailability method should be a boolean value")
            );
        }
        @Test
        void testColor(){
            assertAll(
                    ()->assertEquals("Red",car.getColor()),
                    ()->assertEquals("red",car.getColor()),
                    ()->assertEquals(1,car.getColor())
            );
        }
        @Test
        void testNumOfDoors(){
            assertAll(
                    ()->assertEquals(4,car.getNumOfDoors()),
                    ()->assertEquals(5,car.getNumOfDoors()),
                    ()->assertEquals("four",car.getNumOfDoors())
            );
        }
    }
}
