package org.example.SASAirlines;

public class EconomyTicket extends Ticket {
    public EconomyTicket(int ticketPrice) {
        super(ticketPrice);
    }

    @Override
    public void printAllowedBaggage() {
        System.out.println("Allowed baggage for (Economy Class): 20 kg");
    }

}
