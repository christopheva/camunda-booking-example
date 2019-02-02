package be.vanauseloos.examples.camunda.booking.common;

public class BookingEvents {
    private BookingInitialisedEvent bookingInitialisedEvent;

    public BookingEvents(BookingInitialisedEvent bookingInitialisedEvent){
        this.bookingInitialisedEvent = bookingInitialisedEvent;
    }

    public BookingInitialisedEvent getBookingInitialisedEvent() {
        return bookingInitialisedEvent;
    }


    public static class BookingInitialisedEvent {
        private String uuid;
        private Long airplaneId;
        private Long carId;
        private Long hotelId;

        public BookingInitialisedEvent(String uuid, Long airplaneId, Long carId, Long hotelId) {
            this.uuid = uuid;
            this.airplaneId = airplaneId;
            this.carId = carId;
            this.hotelId = hotelId;
        }

        public String getUuid() {
            return uuid;
        }

        public Long getAirplaneId() {
            return airplaneId;
        }

        public Long getCarId() {
            return carId;
        }

        public Long getHotelId() {
            return hotelId;
        }

        @Override
        public String toString() {
            return "BookingInitialisedEvent{" +
                    "uuid='" + uuid + '\'' +
                    ", airplaneId=" + airplaneId +
                    ", carId=" + carId +
                    ", hotelId=" + hotelId +
                    '}';
        }
    }


    public static class HotelBookedEvent extends BookingEvents{
        public HotelBookedEvent(BookingInitialisedEvent bookingInitialisedEvent) {
            super(bookingInitialisedEvent);
        }
    }


    public static class CarBookedEvent extends BookingEvents{
        public CarBookedEvent(BookingInitialisedEvent bookingInitialisedEvent) {
            super(bookingInitialisedEvent);
        }
    }

    public static class AirplaneBookedEvent extends BookingEvents{
        public AirplaneBookedEvent(BookingInitialisedEvent bookingInitialisedEvent) {
            super(bookingInitialisedEvent);
        }
    }
}
