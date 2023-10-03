package org.example.SASAirlines;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TicketList ticketList = new TicketList();

        // Tilføj nogle billetter til listen
        ticketList.addTicket(new EconomyTicket( 500));
        ticketList.addTicket(new BusinessTicket(1000));
        ticketList.addTicket(new EconomyTicket(600));

        // Udskriv de tilladte bagagevægte for alle billetter
        ticketList.printAllowedBaggageForAllTickets();
    }
}