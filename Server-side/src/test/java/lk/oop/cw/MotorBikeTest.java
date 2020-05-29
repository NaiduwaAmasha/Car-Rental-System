package lk.oop.cw;

import lk.oop.cw.Models.MotorBike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MotorBikeTest {
    private MotorBike motorBike;

    @BeforeEach
    void intiEach(){
        motorBike = new MotorBike(156.12,5300,3.5);
    }
    @Nested
    class testMotorBike{

        @Test
        void testSeatHeight(){
            assertAll(
                    ()->assertEquals(156.12,motorBike.getSeatHeight()),
                    ()->assertEquals(156,motorBike.getSeatHeight()),
                    ()->assertEquals( "156.12",motorBike.getSeatHeight())
            );
        }
        @Test
        void testTankCapacity(){
            assertAll(
                    ()->assertEquals(5300,motorBike.getTankCapacity()),
                    ()->assertEquals(5300.0,motorBike.getTankCapacity()),
                    ()->assertEquals("5300",motorBike.getTankCapacity())
            );
        }
        @Test
        void testLuggageWeight(){
            assertAll(
                    ()->assertEquals(3.5, motorBike.getLuggageWeight()),
                    ()->assertEquals(3,motorBike.getLuggageWeight()),
                    ()->assertEquals("3.5",motorBike.getLuggageWeight())
            );
        };
    }
}
