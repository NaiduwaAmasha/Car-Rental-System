package lk.oop.cw.Models;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.ArrayList;
public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
    @Query(value="SELECT * from vehicle v where not EXISTS(SELECT * from schedule s  where v.plateNum = s.plateNum AND s.pickUpDate>=:pickUpDate AND s.dropOffDate<=:dropOffDate)", nativeQuery = true)
    public ArrayList<Vehicle> findSchedulesByVehicleExists(@Param("pickUpDate") String pickUpDate,
                                                            @Param("dropOffDate") String dropOffDate);

}
