import java.util.ArrayList;

public class TicketController {
    private ArrayList<Ticket> ticketList;
    private ArrayList<Coupon> couponList;

    public TicketController(ArrayList<Ticket> ticketList, ArrayList<Coupon> couponList) {
        this.ticketList = ticketList;
        this.couponList = couponList;
    }

    public Ticket createTicket(Seat seat) {
        DBManager db = DBManager.getInstance();
        Ticket ticket = new Ticket(seat);
        ticketList.add(ticket);
        db.addTicket(ticket);
        // Use EmailManager to send an email?
        return ticket;
    }

    public Coupon cancelTicket(String ticketID, RegisteredUser user) {
        DBManager db = DBManager.getInstance();

        Ticket ticket = findTicket(ticketID);
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
