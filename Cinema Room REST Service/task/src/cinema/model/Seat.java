package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private Integer row;
    private Integer column;
    private Integer price;
    private Boolean purchased;

    public Seat() {
    }

    public Seat(Integer row, Integer column) {
        this.column = column;
        this.row = row;
        this.purchased = false;
        this.setPrice();
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice() {
        price = row <= 4 ? 10 : 8;
    }

    @JsonIgnore
    public Boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

}
