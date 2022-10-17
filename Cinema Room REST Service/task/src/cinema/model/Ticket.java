package cinema.model;

public class Ticket {
    private Token token;
    private Seat ticket;

    public Ticket(Seat seat) {
        this.ticket = seat;
        this.token = new Token();
    }

    public String getToken() {
        return token.getToken();
    }

    public Seat getTicket() {
        return ticket;
    }
}
