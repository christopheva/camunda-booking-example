package be.vanauseloos.examples.camunda.booking;

import be.vanauseloos.examples.camunda.ProcessConstants;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingEventListener {

    @Autowired
    ProcessEngine processEngine;

    @RequestMapping(method = RequestMethod.POST)
    public String handleBooking(@RequestParam Long airplaneId, @RequestParam Long carId, @RequestParam Long hotelId) {
        String uuid = UUID.randomUUID().toString();

        processEngine.getRuntimeService().startProcessInstanceByKey(ProcessConstants.PROCESS_KEY_booking, //
                Variables //
                        .putValue(ProcessConstants.VAR_NAME_uuid, uuid) //
                        .putValue(ProcessConstants.VAR_NAME_airplaneId, airplaneId) //
                        .putValue(ProcessConstants.VAR_NAME_carId, carId) //
                        .putValue(ProcessConstants.VAR_NAME_hotelId, hotelId));

        return uuid;
    }
}
