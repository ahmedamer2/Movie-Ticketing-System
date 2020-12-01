package model;

import java.time.LocalDateTime;

/**
 * This class represents a Ticket for the Movie and stores all of its details 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Ticket {
    private Seat seat;
    private String ticketID;
    private LocalDateTime issueDate;

    /**
     * This is a constructor of Ticket which takes in Seat for the Ticket and creates a new Ticket for that
     * Seat
     * @param seat object of type Seat representing the Seat of the Ticket
     */
    public Ticket(Seat seat) {
        this.seat = seat;
        this.ticketID = Randomizer.generateRandomString(9);
        this.issueDate = LocalDateTime.now();
    }

    /**
     * This functions generates a Coupon for the Ticket when it is cancelled
     * @param isRegistered this is a variable of type boolean which represents if the user who purchased the 
     * Ticket is registered or ordinary user 
     * @return returns Coupon generated for that Ticket when it is cancelled
     */
    public Coupon generateCoupon(boolean isRegistered) {
        if (isRegistered)
            return new Coupon(seat.getPrice());
        else
            return new Coupon(seat.getPrice() * 0.85);
    }

    // Getters and Setters

    /**
     * getter function used to get the seat of the Ticket
     * @return returns an object of type Seat representing the seat of the Ticket
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * setter function used to set the seat of the Ticket to the seat passed as an argument
     * @param seat  an object of type Seat representing the seat of the Ticket 
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * getter function used to get the ticketID of the Ticket
     * @return returns String representing the ticketID of the Ticket
     */
    public String getTicketID() {
        return ticketID;
    }

    /**
     * getter function used to get the issueDate of the Ticket
     * @return returns an variable of type LocalDateTime representing the issueDate of the Ticket
     */
    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    @Override
    /**
     * this function gets all the details of the Ticket
     * @return String representing all the details of the Ticket
     */
    public String toString() {
        String st = "";
        st += "Ticket ID: " + ticketID;
        st += "\nMovie title: " + seat.getShowTime().getMovie().getTitle();
        st += "\nShowTime: " + seat.getShowTime().toString();
        char seatCol = (char) (seat.getCol() + 65);
        st += "\n Seat: " + seat.getRow() + ", " + seatCol;
        return st;
    }
}
