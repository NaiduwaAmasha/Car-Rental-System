package lk.oop.cw;

import lk.oop.cw.Models.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    void initEach() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String str= "1982/08/22";
        Date date = dateFormat.parse(str);
        customer = new Customer(98723456,"Nimal","Perera",date,true,true);
    }

    @Nested
    class customerTest{
        @Test
        void testNICNo(){
            assertAll(
                    ()-> assertEquals(98723456,customer.getCusNICNo()),
                    ()-> assertEquals(98724456,customer.getCusNICNo()),
                    ()->assertEquals("98723456",customer.getCusNICNo())
            );
        }
        @Test
        void testCusFName(){
            assertAll(
                    ()->assertEquals("Nimal",customer.getCusFirstName()),
                    ()->assertEquals("Kamal",customer.getCusFirstName()),
                    ()->assertEquals(3243,customer.getCusFirstName())
            );
        }
        @Test
        void testCusLName(){
            assertAll(
                    ()->assertEquals("Perera",customer.getCusLastName()),
                    ()->assertEquals("Silva",customer.getCusLastName())
            );
        }
        @Test
        void testDob() throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            Date date1 = dateFormat.parse("1982/08/22");
            Date date2 = dateFormat.parse("1982/08/21");
            assertAll(
                    ()->assertEquals(date1,customer.getCusDOB()),
                    ()->assertEquals(date2,customer.getCusDOB())
            );
        }
        @Test
        void testLicenseAvailability(){
            assertAll(
                    ()->assertEquals(true,customer.isLicenseAvailability()),
                    ()->assertEquals(false,customer.isLicenseAvailability())
            );
        }
        @Test
        void testPeriodOfLicenseOwnership(){
            assertAll(
                    ()->assertEquals(true,customer.getPeriodOfLicenseOwnership()),
                    ()->assertEquals(false,customer.getPeriodOfLicenseOwnership())
            );
        }

    }
}
