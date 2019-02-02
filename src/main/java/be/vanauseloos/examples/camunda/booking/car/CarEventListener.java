package be.vanauseloos.examples.camunda.booking.car;

import be.vanauseloos.examples.camunda.booking.common.BookingEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CarEventListener {

    @Autowired
    private ApplicationContext applicationContext;

    @EventListener
    public void handleBookingEvent(BookingEvents.HotelBookedEvent hotelBookedEvent){
        System.out.println("HANDLE HOTEL BOOKED EVENT");

        applicationContext.publishEvent(new BookingEvents.CarBookedEvent(hotelBookedEvent.getBookingInitialisedEvent()));
    }
}
