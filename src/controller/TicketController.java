package controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.*;

/**
 * This class manages all tickets and coupons for the theatre
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class TicketController {
    private ArrayList<Ticket> ticketList;
    private ArrayList<Coupon> couponList;

    /**
     * Contructor for the Ticket controller, initializes the ticket and coupon
     * arrays
     * 
     * @param ticketList the list of tickets from the database
     * @param couponList the list of coupons from the database
     */
    public TicketController(ArrayList<Ticket> ticketList, ArrayList<Coupon> couponList) {
        this.ticketList = ticketList;
        this.couponList = couponList;
    }

    /**
     * Creates a new ticket for a specific seat
     * 
     * @param seat the seat to create the ticket for
     * @return the Ticket that was created
     */
    public Ticket createTicket(Seat seat) {
        DBManager db = DBManager.getInstance();
        seat.setAvailable(false);
        Ticket ticket = new Ticket(seat);
        ticketList.add(ticket);
        db.addTicket(ticket);
        return ticket;
    }

    /**
     * Verifies if an exclusive movie has its 10% capacity filled out
     * 
     * @param st the showtime to check
     * @return if the exclusive showtime is full or not
     */
    public boolean verifyExclusiveMovieAvailability(ShowTime st) {
        ArrayList<Seat> seatList = st.getSeatList();
        int seatsPurchased = 0;
        for (Seat s : seatList) {
            if (!s.isAvailable()) {
                seatsPurchased++;
            }
        }

        if ((double) seatsPurchased / seatList.size() > 0.1)
            return false;
        return true;
    }

    /**
     * Verifies if a ticket is redeemable based on a 72hour expiration period.
     * 
     * @param t the ticket to check
     * @return True if the ticket is redeemable, false otherwise
     */
    public boolean verifyCancellation(Ticket t) {
        long time_diff = Math.abs(Duration.between(LocalDateTime.now(), t.getIssueDate()).toHours());

        if (time_diff > 72) {
            return false;
        }
        return true;
    }

    /**
     * Cancels a ticket
     * 
     * @param ticketID the id of the ticket to cancel
     * @param user     the user information, user determining the coupon value.
     * @return the coupon that was created from the ticket cancellation
     */
    public Coupon cancelTicket(String ticketID, RegisteredUser user) {
        DBManager db = DBManager.getInstance();
        Ticket ticket = findTicket(ticketID);
        ticket.getSeat().setAvailable(true);
        Coupon coupon = null;

        if (ticket != null) {
            coupon = ticket.generateCoupon(user != null);
            ticketList.remove(ticket);
            couponList.add(coupon);
            db.cancelTicket(ticket, coupon);
        }
        return coupon;
    }

    /**
     * finds a ticket given a ticketID
     * 
     * @param ticketID the id of the ticket to find
     * @return returns a ticket if it was found, null otherwise
     */
    public Ticket findTicket(String ticketID) {
        for (Ticket t : ticketList) {
            if (t.getTicketID().equals(ticketID))
                return t;
        }
        return null;
    }

    /**
     * fonds a coupon given a couponID
     * 
     * @param couponID the id of the coupon to find
     * @return returns a coupon if it was found, null otherwise
     */
    public Coupon findCoupon(String couponID) {
        for (Coupon c : couponList) {
            if (c.getCouponID().equals(couponID))
                return c;
        }
        return null;
    }

    /**
     * retrieves the theatre's ticket list
     * 
     * @return the list of tickets
     */
    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    /**
     * retreives the theatre's coupon list
     * 
     * @return the list of coupons
     */
    public ArrayList<Coupon> getCouponList() {
        return couponList;
    }
}
