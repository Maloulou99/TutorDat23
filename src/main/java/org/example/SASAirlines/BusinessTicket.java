package org.example.SASAirlines;

public class BusinessTicket extends Ticket {
    public BusinessTicket(int ticketPrice) {
        super(ticketPrice);
    }

    @Override
    public void printAllowedBaggage() {
        System.out.println("Allowed baggage for (Business Class): 30 kg");
    }

}
