package model;

/**
 * This class represents a Seat along with all the details
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Seat {
    private ShowTime showTime;
    private int row;
    private int col;
    private boolean isAvailable;
    private double price;

    /**
     * This is a constructor for Seat which takes in all the details of the Seat and creates a new Seat
     * @param row this is a variable of type int representing the row of the Seat
     * @param col this is a variable of type int representing the coloumn of the Seat
     * @param price this is a variable of type double representing the price of the Seat
     * @param showTime this is an object of type ShowTime representing the showTime in which 
     * the Seat is present 
     */
    public Seat(int row, int col, double price, ShowTime showTime) {
        this.row = row;
        this.col = col;
        this.price = price;
        isAvailable = true;
        this.showTime = showTime;
    }

    // Getters and Setters
    /**
     * This function tells if the Seat is available or occupied by returning variable isAvailable in Seat
     * @return returns a boolean(true/false) representing if the Seat is available(true) or occupied(false)
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * setter function used to set the value of isAvailable to the isAvailable of type boolean passed as an argument
     * @param isAvailable variable of type boolean representing if the seat is available or occupied 
     */
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * getter function used to get the show time of the Seat
     * @return returns an object of type ShowTime representing the showTime of the Seat
     */
    public ShowTime getShowTime() {
        return showTime;
    }

    /**
     * getter function used to get the row of the Seat
     * @return returns a variable of type int representing the row of the Seat
     */
    public int getRow() {
        return row;
    }

    /**
     * setter function used to set the row of the Seat to the row passed as an argument
     * @param row this is variable of type int representing the row of the Seat
     */
    public void setRow(int row) {
        this.row = row;
    }
    /**
     * getter function used to get the coloumn of the Seat
     * @return returns a variable of type int representing the col of the Seat
     */
    public int getCol() {
        return col;
    }

    /**
     * setter function used to set the coloumn of the Seat to the col passed as an argument
     * @param col this is variable of type int representing the col of the Seat
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * getter function used to get the price of the Seat
     * @return returns a variable of type double representing the price of the Seat
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter function used to set the price of the Seat to the price passed as an argument
     * @param price this is variable of type int representing the price of the Seat
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
