# camunda-booking-example
Use case brainstorm:
- Flow: Book airplane -> Book hotel -> book car -> Booking confirmed
- Communication between bounded context = events
- Compensating transactions
  - If "book car" fails, the previous steps need to be rollbacked; car and hotel.
- Each bounded context communicates with an external payment system?
- 

