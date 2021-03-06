package controller;

import java.util.ArrayList;

import javax.swing.event.MouseInputAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.*;
import model.*;

/**
 * This is the main controller that manages all other controllers and ties the
 * backend with the frontend
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 30, 2020
 */
public class ApplicationController {
    TicketController tc;
    PaymentManager pm;
    EmailManager em;
    AuthenticationSystem auth;
    ArrayList<Movie> movieList;
    RegisteredUser currentUser;
    ViewController vc;
    final String theatreCardNumber = "1234567812345678";

    /**
     * Constructor for the Application Controller, initializes all other controllers
     * using the DBManager.
     */
    public ApplicationController() {
        DBManager db = DBManager.getInstance();
        tc = new TicketController(db.getTickets(), db.getCoupons());
        pm = new PaymentManager(db.getPayments());
        em = new EmailManager();
        auth = new AuthenticationSystem();
        movieList = db.getMovies();
        vc = new ViewController();
        currentUser = null;
        db.populateSeats(tc);
    }

    /**
     * Shows the Login view and sets up its ActionListeners
     */
    public void login() {
        LoginView login = vc.createLoginView();

        login.addLoginListener((ActionEvent e) -> {
            String email = login.getEmail();
            String pass = login.getPass();

            if (pass.isBlank() || email.isBlank()) {
                vc.displayMessage("Make sure all fields are filled out");
            } else {
                RegisteredUser user = auth.verifyCredentials(email, pass);
                if (user == null) {
                    vc.displayMessage("A User with these credentials does not exist");
                } else {
                    currentUser = user;
                    vc.displayMessage("Login Successful");
                    mainAppView();
                }
            }
        });

        login.addCancelListener((ActionEvent e) -> {
            appEntry();
        });
    }

    /**
     * Shows the Register view and sets up its ActionListeners
     */
    public void register() {
        RegisterView register = vc.createRegisterView();

        register.addRegisterListener((ActionEvent e) -> {
            String email = register.getEmail();
            String pass = register.getPass();

            if (pass.isBlank() || email.isBlank()) {
                vc.displayMessage("Make sure all fields are filled out");
            } else if (!InputChecker.checkEmail(email)) {
                vc.displayMessage("Invalid Email Format");
            } else {
                RegisteredUser user = new RegisteredUser(email, pass, "Not a Field", "Not a Field");

                if (!auth.registerNewUser(user)) {
                    vc.displayMessage("This Email is already being used, Please try again.");
                } else {
                    em.emailRegistration(user.getEmail());
                    vc.displayMessage("Registration Successful");
                    appEntry();
                }
            }
        });

        register.addCancelListener((ActionEvent e) -> {
            appEntry();
        });
    }

    /**
     * Shows the Entry Page of the app
     */
    public void appEntry() {
        MainView main = vc.createMainView();

        main.addLoginListener((ActionEvent e) -> {
            login();
        });

        main.addRegisterListener((ActionEvent e) -> {
            register();
        });

        main.addContinueListener((ActionEvent e) -> {
            mainAppView();
        });
    }

    /**
     * Displays the Movie View and sets up ActionListeners for every Movie
     */
    public void browseMovies() {
        MovieView movieView = vc.createMovieView(movieList, currentUser != null);

        movieView.addBackListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainAppView();
            }
        });

        ArrayList<MouseListener> events = new ArrayList<MouseListener>();

        for (int i = 0; i < movieList.size(); i++) {
            int index = i;
            events.add(new MouseInputAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Movie selectedMovie = movieView.getMovie(index);
                    browseShowtimes(selectedMovie);
                }
            });
        }

        movieView.addMovieListners(events);
    }

    /**
     * Displays the ShowTime View and sets up ActionListeners for every ShowTime
     * 
     * @param selectedMovie Display this movie's showtimes
     */
    public void browseShowtimes(Movie selectedMovie) {
        ShowTimeView stView = vc.createShowTimeView(selectedMovie);

        stView.addBackListener((ActionEvent e) -> {
            browseMovies();
        });

        ArrayList<ActionListener> events = new ArrayList<ActionListener>();

        ArrayList<ShowTime> stList = selectedMovie.getShowTimeList();
        for (int i = 0; i < stList.size(); i++) {
            int index = i;
            events.add((ActionEvent e) -> {
                ShowTime selectedST = stView.getShowTime(index);
                browseSeats(selectedST);
            });
        }

        stView.addShowTimeListeners(events);
    }

    /**
     * Displays the Seat View and sets up ActionListeners for every Seat
     * 
     * @param st Display this showtime's seats
     */
    public void browseSeats(ShowTime st) {
        // If a movie is exclusive, check if 10% of the seats have been already
        // purchased
        boolean seatsAvailable = true;
        if (!st.getMovie().isReleased()) {
            seatsAvailable = tc.verifyExclusiveMovieAvailability(st);
        }

        SeatView seatView = vc.createSeatView(st, seatsAvailable);

        seatView.addBackListener((ActionEvent e) -> {
            browseShowtimes(st.getMovie());
        });

        ArrayList<ActionListener> events = new ArrayList<ActionListener>();

        ArrayList<Seat> seatList = st.getSeatList();
        for (int i = 0; i < seatList.size(); i++) {
            int index = i;
            events.add((ActionEvent e) -> {
                Seat selectedSeat = seatView.getSeat(index);
                purchaseTicket(selectedSeat, currentUser != null);
            });
        }

        seatView.addSeatListeners(events);
    }

    /**
     * Displays the Cancel Ticket Confirmation page
     * 
     * @param t the ticket being cancelled
     */
    public void cancelTicket(Ticket t) {
        CancelTicketView view = vc.createCancelTicketView(t, currentUser != null);

        view.addCancelListener((ActionEvent e) -> {
            mainAppView();
        });

        view.addConfirmListener((ActionEvent e) -> {
            Ticket ticketToCancel = view.getTicket();
            String email = view.getEmail();
            if (email.isBlank() && currentUser == null) {
                vc.displayMessage("You are not logged in: Please enter an email to receive the coupon!");
            } else if (!InputChecker.checkEmail(email) && currentUser == null) {
                vc.displayMessage("Invalid Email Format");
            } else {
                Coupon c = tc.cancelTicket(ticketToCancel.getTicketID(), currentUser);
                if (currentUser != null)
                    em.emailTicketCancellation(currentUser.getEmail(), c);
                else
                    em.emailTicketCancellation(email, c);
                mainAppView();
            }
        });

    }

    /**
     * Displays the View to search for a ticket before cancellation
     */
    public void searchTicket() {
        TicketSearchView view = vc.createTicketSearchView();

        view.addCancelListener((ActionEvent e) -> {
            mainAppView();
        });

        view.addSearchListener((ActionEvent e) -> {
            String ticketID = view.getTicketID();
            if (ticketID.isBlank()) {
                vc.displayMessage("Make sure all fields are filled");
            } else {
                Ticket ticketToCancel = tc.findTicket(ticketID);
                if (ticketToCancel != null) {
                    if (tc.verifyCancellation(ticketToCancel))
                        cancelTicket(ticketToCancel);
                    else
                        vc.displayMessage("Cannot Cancel Tickets purchased more than 72 hours ago");
                } else {
                    vc.displayMessage("No Ticket was found.");
                }
            }
        });
    }

    /**
     * Displays the Purchase Ticket page and set's up logic for purchasing
     * 
     * @param s            the seat being purchased
     * @param isRegistered flag to indicate if the user is registered
     */
    public void purchaseTicket(Seat s, boolean isRegistered) {
        PurchaseTicketView view = vc.createPurchaseTicketView(s, isRegistered);

        view.addCancelButtonListener((ActionEvent e) -> {
            browseSeats(s.getShowTime());
        });

        view.addPurchaseButtonListener((ActionEvent e) -> {
            String email = view.getEmail();
            String name = view.getName();
            String cardNumber = view.getCardNumber();
            String year = view.getYear();
            String month = view.getMonth();
            String cvv = view.getCvvNumber();
            String couponID = view.getCoupon();
            double amountToPay = s.getPrice();

            // Error Checking Inputs
            if (!InputChecker.checkNumber(cardNumber, 16) || !InputChecker.checkNumber(cvv, 3) || name.isBlank()) {
                vc.displayMessage("make sure all information entered is correct");
                return;
            } else if (!InputChecker.checkEmail(email) && !isRegistered) {
                vc.displayMessage("Invalid email field");
                return;
            }

            // Redeeming Coupon
            if (!couponID.isBlank()) {
                Coupon c = tc.findCoupon(couponID);
                if (c == null) {
                    vc.displayMessage("Could Not Find Coupon");
                    return;
                }
                amountToPay -= c.getValue();
            }

            // Processing Payment
            if (!pm.processPayment(new Payment(amountToPay, cardNumber, theatreCardNumber))) {
                vc.displayMessage("Payment Failed");
                return;
            }

            // Create ticket and send confirmation email
            Ticket newTicket = tc.createTicket(s);
            if (currentUser == null)
                em.emailTicketPurchase(email, newTicket, amountToPay);
            else
                em.emailTicketPurchase(currentUser.getEmail(), newTicket, amountToPay);

            vc.displayMessage("Payment Succesful, Look for an email with your ticket info");
            mainAppView();
        });

    }

    /**
     * Displays the Main App view after logging in
     */
    public void mainAppView() {
        MainAppView app = vc.createAppView(currentUser);

        app.addCancelTicketListener((ActionEvent e) -> {
            searchTicket();
        });

        app.addMoviesListener((ActionEvent e) -> {
            browseMovies();
        });
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.appEntry();
    }
}
