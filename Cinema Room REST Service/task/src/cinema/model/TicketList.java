package cinema.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TicketList {
    private Map<String, Ticket> seatList;

    public TicketList() {
        this.seatList = new HashMap<>();
    }

    public void add(Ticket ticket) {
        seatList.put(ticket.getToken(), ticket);
    }

    public boolean containsKey(Token token) {
        return seatList.containsKey(token.getToken());
    }

    public void remove(String token) {
        seatList.remove(token);
    }

    public Ticket getTicket(String token) {
        return seatList.get(token);
    }

    public Map<String, Ticket> getSeatList() {
        return seatList;
    }
}
