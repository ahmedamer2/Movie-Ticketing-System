package controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.*;

public class TicketController {
    private ArrayList<Ticket> ticketList;
    private ArrayList<Coupon> couponList;

    public TicketController(ArrayList<Ticket> ticketList, ArrayList<Coupon> couponList) {
        this.ticketList = ticketList;
        this.couponList = couponList;
    }

    public Ticket createTicket(Seat seat) {
        DBManager db = DBManager.getInstance();
        seat.setAvailable(false);
        Ticket ticket = new Ticket(seat);
        ticketList.add(ticket);
        db.addTicket(ticket);
        return ticket;
    }

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

    public boolean verifyCancellation(Ticket t) {
        long time_diff = Math.abs(Duration.between(LocalDateTime.now(), t.getIssueDate()).toHours());

        if (time_diff > 72) {
            return false;
        }
        return true;
    }

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

    public Ticket findTicket(String ticketID) {
        for (Ticket t : ticketList) {
            if (t.getTicketID().equals(ticketID))
                return t;
        }
        return null;
    }

    public Coupon findCoupon(String couponID) {
        for (Coupon c : couponList) {
            if (c.getCouponID().equals(couponID))
                return c;
        }
        return null;
    }

    // Getters
    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public ArrayList<Coupon> getCouponList() {
        return couponList;
    }
}
