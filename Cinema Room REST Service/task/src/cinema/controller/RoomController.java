package cinema.controller;

import cinema.exceptions.TicketSoldOutException;
import cinema.model.*;
import cinema.exceptions.OutOfBoundsException;
import cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/seats")
    public Room getSeats() {
        return roomService;
    }

    @PostMapping("/purchase")
    public Ticket purchase(@RequestBody Seat seat) {

        Seat seatFound = roomService.findSeat(seat.getRow(), seat.getColumn());

        if (seatFound == null) {
            throw new OutOfBoundsException("The number of a row or a column is out of bounds!");
        }

        if (seatFound.isPurchased()) {
            throw new TicketSoldOutException("The ticket has been already purchased!");
        }
        return roomService.purchase(seatFound);
    }

    @PostMapping("/return")
    public ReturnedTicket returnTicket(@RequestBody Token token) {
        ReturnedTicket returnedTicket = roomService.returnTicket(token);

        if (returnedTicket == null) {
            throw new OutOfBoundsException("Wrong token!");
        }
        return returnedTicket;
    }

}
