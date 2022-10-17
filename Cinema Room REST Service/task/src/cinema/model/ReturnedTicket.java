package cinema.model;

public class ReturnedTicket {
    private Seat returnedTicket;
    private TicketList ticketList;

    public ReturnedTicket(String token, TicketList ticketList) {
        this.ticketList = ticketList;
        this.returnedTicket = ticketList.getTicket(token).getTicket();
    }

    public Seat getReturnedTicket() {
        return returnedTicket;
    }
}
