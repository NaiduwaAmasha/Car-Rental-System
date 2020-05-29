package lk.oop.cw.Controller;

import lk.oop.cw.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

    @RestController  // This means that this class is a Controller
    @RequestMapping(path="/api")
    public class MainController {
        @Autowired
        private VehicleBaseRepository vehicleBaseRepository;

        @Autowired
        private CustomerRepository customerRepository;

       @Autowired
        private ScheduleRepository scheduleRepository;

        @CrossOrigin
        @GetMapping(path="/get")
        public @ResponseBody
        Iterable getAllVehicles() {
            // This returns a JSON or XML with the vehicles
            return vehicleBaseRepository.findAll();
        }

        @CrossOrigin
        @PostMapping(path="/addCustomer")
        public Customer addCustomer(@ModelAttribute Customer customer){
            return customerRepository.save(customer);
        }

        @CrossOrigin
        @GetMapping(path="/getAvailableVehicles")
        @ResponseBody
        public Iterable getAvailableVehicles(@RequestParam(defaultValue = "test") String pickupDate,
                                        @RequestParam(defaultValue = "test") String dropOffDate) {
            // This returns a JSON or XML with the vehicles
            return vehicleBaseRepository.findSchedulesByVehicleExists(pickupDate,dropOffDate);
        }

        @CrossOrigin
        @PostMapping(path="/addSchedule")
        public Schedule addSchedule(@ModelAttribute Schedule schedule){
            return scheduleRepository.save(schedule);
        }

    }

