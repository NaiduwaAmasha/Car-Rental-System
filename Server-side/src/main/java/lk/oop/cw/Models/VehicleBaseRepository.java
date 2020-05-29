package lk.oop.cw.Models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface VehicleBaseRepository<T extends Vehicle> extends CrudRepository<T, String> {
    @Query(value="SELECT * from vehicle v where not EXISTS(SELECT * from schedule s  where v.plateNum = s.plateNum AND s.pickUpDate>=:pickUpDate AND s.dropOffDate<=:dropOffDate)", nativeQuery = true)
    public ArrayList<Vehicle> findSchedulesByVehicleExists(@Param("pickUpDate") String pickUpDate,
                                                           @Param("dropOffDate") String dropOffDate);
}

@Transactional
interface VehicleRepository extends VehicleBaseRepository<Vehicle>{}

@Transactional
interface CarRepository extends VehicleBaseRepository<Car>{}

@Transactional
interface MotorBikeRepository extends VehicleBaseRepository<MotorBike>{}


