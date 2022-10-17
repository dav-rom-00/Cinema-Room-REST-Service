package cinema.service;

import cinema.model.*;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends Room {
    private TicketList ticketList;

    public RoomService(TicketList ticketList) {
        this.ticketList = ticketList;
    }

    public Seat findSeat(Integer row, Integer column) {
        for (int i = 0; i < getAvailableSeats().length; i++) {
            if (row.intValue() == getAvailableSeats()[i].getRow().intValue()
                    && column.intValue() == getAvailableSeats()[i].getColumn().intValue()) {
                return getAvailableSeats()[i];
            }
        }
        return null;
    }

    public Ticket purchase(Seat seat) {
        seat.setPurchased(true);
        Ticket ticket = new Ticket(seat);
        ticketList.add(ticket);
        return ticket;
    }

    public ReturnedTicket returnTicket(Token token) {

        if (ticketList.containsKey(token)) {
            ReturnedTicket returnedTicket = new ReturnedTicket(token.getToken(), ticketList);
            ticketList.getTicket(token.getToken()).getTicket().setPurchased(false);
            ticketList.remove(token.getToken());
            return returnedTicket;
        }
        return null;
    }


}
