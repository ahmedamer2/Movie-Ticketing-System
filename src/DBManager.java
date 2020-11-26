import java.util.ArrayList;
import java.util.HashMap;

public class DBManager {
    static private DBManager instance = null;

    private ArrayList<RegisteredUser> users;
    private ArrayList<Ticket> tickets;
    private ArrayList<Coupon> coupons;
    private ArrayList<Payment> payments;

    private Theatre theatre;
    private HashMap<Integer, Double> creditCards;

    private ArrayList<Movie> movies;
    private ArrayList<ShowTime> showTimes;
    private ArrayList<Seat> seats;

    static public DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public DBManager() {
        // Get Data from Database
        users = new ArrayList<RegisteredUser>();
        tickets = new ArrayList<Ticket>();
        coupons = new ArrayList<Coupon>();
        creditCards = new HashMap<Integer, Double>();
        movies = new ArrayList<Movie>();
        showTimes = new ArrayList<ShowTime>();
        seats = new ArrayList<Seat>();
        payments = new ArrayList<Payment>();
        theatre = new Theatre("MyTheatre", new Address(1234, "street", "U4K7I2", "calgary", "alberta", "CA"), movies);
    }

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

    public void addPayment(Payment payment) {
        payments.add(payment);
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
