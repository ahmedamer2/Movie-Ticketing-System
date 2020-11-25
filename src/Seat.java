public class Seat {
    private int row;
    private int col;
    private boolean isAvailable;
    private double price;

    public Seat(int row, int col, double price) {
        this.row = row;
        this.col = col;
        this.price = price;
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Getters and Setters
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
