package be.vanauseloos.examples.camunda.booking;

import be.vanauseloos.examples.camunda.booking.common.BookingEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/booking")
public class BookingEventListener {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(method = RequestMethod.POST)
    public String handleBooking(@RequestParam Long airplaneId, @RequestParam Long carId, @RequestParam Long hotelId){
        String uuid = UUID.randomUUID().toString();

        applicationContext.publishEvent(new BookingEvents.BookingInitialisedEvent(uuid, airplaneId, carId, hotelId));


        return uuid;
    }
}
