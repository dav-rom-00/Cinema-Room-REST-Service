package cinema.model;

import org.springframework.stereotype.Component;

@Component
public class Stats {
    private Integer currentIncome;
    private Integer numberOfAvailableSeats;
    private Integer numberOfPurchasedTickets;
    private TicketList ticketList;
    private Room room;

    public Stats(TicketList ticketList, Room room) {
        this.room = room;
        this.ticketList = ticketList;
        resetDefaultValues();
    }

    public void getStats() {
        resetDefaultValues();
        calculateIncome();
        numberOfAvailableSeats -= ticketList.getSeatList().size();
        numberOfPurchasedTickets = ticketList.getSeatList().size();
    }

    private void calculateIncome() {
        for (Ticket ticket : ticketList.getSeatList().values()) {
            currentIncome += ticket.getTicket().getPrice();
        }
    }

    private void resetDefaultValues() {
        this.numberOfAvailableSeats = room.getTotalColumns() * room.getTotalRows();
        this.currentIncome = 0;
        this.numberOfPurchasedTickets = 0;
    }


    public Integer getCurrentIncome() {
        return currentIncome;
    }

    public Integer getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public Integer getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }
}
