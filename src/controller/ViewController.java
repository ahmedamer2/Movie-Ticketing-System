package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;
import model.Movie;
import model.RegisteredUser;
import model.Ticket;
import model.Seat;
import model.ShowTime;

/**
 * This class manages all the front end views and creates them for the
 * application controller to user
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 30, 2020
 */
public class ViewController {
    JFrame mainFrame;
    JPanel currentPanel = null;

    /**
     * contructor for the View Controller. Sets up the main frame
     */
    public ViewController() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Ticket Registration System");
        mainFrame.setIconImage(new ImageIcon("src//Images//popcorn.png").getImage());
        mainFrame.setVisible(true);
    }

    /**
     * displays a pop-up message to the user
     * 
     * @param msg the message to display
     */
    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(mainFrame, msg);
    }

    /**
     * creates the register view
     * 
     * @return the register view that was create
     */
    public RegisterView createRegisterView() {
        removeCurrentPanel();
        RegisterView register = new RegisterView();
        currentPanel = register;
        mainFrame.add(register);
        mainFrame.pack();
        return register;
    }

    /**
     * creates the purchase ticket view
     * 
     * @param s            the seat being purchased
     * @param isRegistered flag showing if the user is registered
     * @return the purchase ticket view that was create
     */
    public PurchaseTicketView createPurchaseTicketView(Seat s, boolean isRegistered) {
        removeCurrentPanel();
        PurchaseTicketView purchaseView = new PurchaseTicketView(s, isRegistered);
        currentPanel = purchaseView;
        mainFrame.add(purchaseView);
        mainFrame.pack();
        return purchaseView;
    }

    /**
     * creates the cancel ticket view
     * 
     * @param t            the ticket to cancel
     * @param isRegistered flag showing if the user is registered
     * @return the cancel ticket view that was create
     */
    public CancelTicketView createCancelTicketView(Ticket t, boolean isRegistered) {
        removeCurrentPanel();
        CancelTicketView cancelView = new CancelTicketView(t, isRegistered);
        currentPanel = cancelView;
        mainFrame.add(cancelView);
        mainFrame.pack();
        return cancelView;
    }

    /**
     * creates the ticket search view
     * 
     * @return the ticket search view that was create
     */
    public TicketSearchView createTicketSearchView() {
        removeCurrentPanel();
        TicketSearchView searchView = new TicketSearchView();
        currentPanel = searchView;
        mainFrame.add(searchView);
        mainFrame.pack();
        return searchView;
    }

    /**
     * creates the main app view that is seen after logging in
     * 
     * @param u the user that is logged in
     * @return the register view that was create
     */
    public MainAppView createAppView(RegisteredUser u) {
        removeCurrentPanel();
        MainAppView app = new MainAppView(u);
        currentPanel = app;
        mainFrame.add(app);
        mainFrame.pack();
        return app;
    }

    /**
     * creates the showtime view using the specific movie information
     * 
     * @param movie the movie to use to display showtimes
     * @return the showtime view that was create
     */
    public ShowTimeView createShowTimeView(Movie movie) {
        removeCurrentPanel();
        ShowTimeView stView = new ShowTimeView(movie);
        currentPanel = stView;
        mainFrame.add(stView);
        mainFrame.pack();
        return stView;
    }

    /**
     * creates the seat view using the specific showtime information
     * 
     * @param st             the showtime to use to display the seats
     * @param seatsAvailable flag used to address an exclusive movie that has a 10%
     *                       capacity
     * @return the seat view that was create
     */
    public SeatView createSeatView(ShowTime st, boolean seatsAvailable) {
        removeCurrentPanel();
        if (!seatsAvailable) {
            displayMessage(
                    "Note: This exclusive movie has 10% of its seats sold. \nUnfortunately, you cannot purchase any more seats before the movie's release");
        }
        SeatView seatView = new SeatView(st, seatsAvailable);
        currentPanel = seatView;
        mainFrame.add(seatView);
        mainFrame.pack();
        return seatView;
    }

    /**
     * creates the movie view using the movie information
     * 
     * @param movies       the list of movies to display
     * @param isRegistered flag to show exclusive movies to registered users
     * @return the showtime view that was create
     */
    public MovieView createMovieView(ArrayList<Movie> movies, boolean isRegistered) {
        removeCurrentPanel();
        MovieView movieView = new MovieView(movies, isRegistered);
        currentPanel = movieView;
        mainFrame.add(movieView);
        mainFrame.pack();
        return movieView;
    }

    /**
     * The main view which displays the login options for the user
     * 
     * @return The view that was created
     */
    public MainView createMainView() {
        removeCurrentPanel();
        MainView main = new MainView();
        currentPanel = main;
        mainFrame.add(main);
        mainFrame.pack();
        return main;
    }

    /**
     * creates the login view
     * 
     * @return the login view that was created
     */
    public LoginView createLoginView() {
        removeCurrentPanel();
        LoginView loginView = new LoginView();
        currentPanel = loginView;
        mainFrame.add(loginView);
        mainFrame.pack();
        return loginView;
    }

    /**
     * removes the current view being displayed
     */
    public void removeCurrentPanel() {
        if (currentPanel != null)
            mainFrame.remove(currentPanel);
    }
}
