import java.time.LocalDateTime;

public class Ticket {
    private Seat seat;
    private String ticketID;
    private LocalDateTime issueDate;

    public Ticket(Seat seat) {
        this.seat = seat;
        this.ticketID = Randomizer.generateRandomString(9);
        this.issueDate = LocalDateTime.now();
    }

    public Coupon generateCoupon(boolean isRegistered) {
        if (isRegistered)
            return new Coupon(seat.getPrice(), ticketID);
        else
            return new Coupon(seat.getPrice() * 0.85, ticketID);
    }

    // Getters and Setters
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getTicketID() {
        return ticketID;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }
}
