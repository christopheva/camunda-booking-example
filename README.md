# camunda-booking-example
Flow: Book airplane -> Book hotel -> book car -> Booking confirmed
For testing and learning purposes we implemented several scenario's.

## Booking command
1 REST api is called to start the booking process.
```
POST http://localhost:8080/booking?airplaneId=1&carId=2&hotelId=3
```

## Airplane
Airplane is booked with a service task. The service task is linked to a spring bean. The booking needs to be confirmed by the user "kermit" in the camunda task view.

## Hotel
An external system is responsible for the booking. The external system is triggered by a JMS message. A service task send the JMS message and a JmsListener bean activates a "Receive task".

## Car
A new process is designed for this booking. Which is triggered by the main flow by a send task.