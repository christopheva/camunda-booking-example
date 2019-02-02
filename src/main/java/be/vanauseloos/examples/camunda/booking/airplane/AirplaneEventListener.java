package be.vanauseloos.examples.camunda.booking.airplane;

import be.vanauseloos.examples.camunda.booking.common.BookingEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AirplaneEventListener {

    @Autowired
    private ApplicationContext applicationContext;

    @EventListener
    public void handleBookingEvent(BookingEvents.BookingInitialisedEvent bookingInitialisedEvent){
        System.out.println("HANDLE BOOKING INITIALISED EVENT");

        applicationContext.publishEvent(new BookingEvents.AirplaneBookedEvent(bookingInitialisedEvent));
    }
}
