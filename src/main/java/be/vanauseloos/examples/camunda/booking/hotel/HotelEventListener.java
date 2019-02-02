package be.vanauseloos.examples.camunda.booking.hotel;

import be.vanauseloos.examples.camunda.booking.common.BookingEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HotelEventListener {

    @Autowired
    private ApplicationContext applicationContext;

    @EventListener
    public void handleBookingEvent(BookingEvents.AirplaneBookedEvent airplaneBookedEvent){
        System.out.println("HANDLE AIRPLANE BOOKED EVENT");

        applicationContext.publishEvent(new BookingEvents.HotelBookedEvent(airplaneBookedEvent.getBookingInitialisedEvent()));
    }
}
