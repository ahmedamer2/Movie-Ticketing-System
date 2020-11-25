import java.util.ArrayList;

public class DBManager {
    private ArrayList<RegisteredUser> users;
    private ArrayList<Ticket> tickets;
    private ArrayList<Coupon> coupons;

    private Theatre theatre;
    private ArrayList<Movie> movies;
    private ArrayList<ShowTime> showTimes;
    private ArrayList<Seat> seats;

    public RegisteredUser getUser(String email) {
        for (RegisteredUser u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean addUser(RegisteredUser user) {
        // Email must be unique
        // Note: This could be more efficient, but not important for this project
        for (RegisteredUser u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                return false;
            }
        }

        users.add(user);
        return true;
    }

    public Ticket getTicket(String ticketID) {
        for (Ticket t : tickets) {
            if (t.getTicketID().equals(ticketID)) {
                return t;
            }
        }
        return null;
    }

    public Coupon getCoupon(String couponID) {
        for (Coupon c : coupons) {
            if (c.getCouponID().equals(couponID)) {
                return c;
            }
        }
        return null;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void cancelTicket(Ticket ticket, Coupon coupon) {
        tickets.remove(ticket);
        coupons.add(coupon);
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<ShowTime> getShowTimes(Movie movie) {
        return movie.getShowTimeList();
    }

    public ArrayList<Seat> getSeats(ShowTime show) {
        return show.getSeatList();
    }
}
