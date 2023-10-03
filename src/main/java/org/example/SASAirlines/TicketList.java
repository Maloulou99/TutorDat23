package org.example.SASAirlines;

import org.example.SASAirlines.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketList {
    private List<Ticket> tickets;

    public TicketList() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void printAllowedBaggageForAllTickets() {
        for (Ticket ticket : tickets) {
            ticket.printAllowedBaggage();
        }
    }
}

