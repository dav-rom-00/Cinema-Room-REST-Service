package cinema.model;

import org.springframework.stereotype.Component;

@Component
public class Room {
    private final Integer totalRows = 9;
    private final Integer totalColumns = 9;
    private Seat[] availableSeats;

    public Room() {
        availableSeats = new Seat[totalRows * totalColumns];
        int counter = 0;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                availableSeats[counter] = new Seat(i + 1, j + 1);
                counter++;
            }
        }
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public Integer getTotalColumns() {
        return totalColumns;
    }

    public Seat[] getAvailableSeats() {
        return availableSeats;
    }

}
