package model;

public class Seat {
    private ShowTime showTime;
    private int row;
    private int col;
    private boolean isAvailable;
    private double price;

    public Seat(int row, int col, double price, ShowTime showTime) {
        this.row = row;
        this.col = col;
        this.price = price;
        isAvailable = true;
        this.showTime = showTime;
    }

    // Getters and Setters
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
