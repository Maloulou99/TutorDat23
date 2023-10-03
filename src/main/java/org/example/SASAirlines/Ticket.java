package org.example.SASAirlines;

public class Ticket {
    private int ticketPrice;

    public Ticket(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void printAllowedBaggage() {
        System.out.println("Allowed baggage 20 kg");
    }
}
