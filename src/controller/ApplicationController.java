package controller;

import java.util.ArrayList;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.*;
import model.*;

public class ApplicationController {
    TicketController tc;
    PaymentManager pm;
    EmailManager em;
    AuthenticationSystem auth;
    ArrayList<Movie> movieList;
    RegisteredUser currentUser;
    MyViewController vc;

    public ApplicationController() {
        DBManager db = DBManager.getInstance();
        tc = new TicketController(db.getTickets(), db.getCoupons());
        pm = new PaymentManager(db.getPayments());
        em = new EmailManager();
        auth = new AuthenticationSystem();
        movieList = db.getMovies();
        vc = new MyViewController();
        currentUser = null;
    }

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

    public void register() {
        RegisterView register = vc.createRegisterView();

        register.addRegisterListener((ActionEvent e) -> {
            String email = register.getEmail();
            String pass = register.getPass();

            if (pass.isBlank() || email.isBlank()) {
                vc.displayMessage("Make sure all fields are filled out");
            } else {
                RegisteredUser user = new RegisteredUser(email, pass, "Not a Field", "Not a Field");

                if (!auth.registerNewUser(user)) {
                    vc.displayMessage("This Email is already being used, Please try again.");
                } else {
                    vc.displayMessage("Registration Successful");
                    appEntry();
                }
            }
        });

        register.addCancelListener((ActionEvent e) -> {
            appEntry();
        });
    }

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

    public void browseMovies() {
        MovieView movieView = vc.createMovieView(movieList);

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

    public void browseShowtimes(Movie selectedMovie) {
        // TODO
        System.out.println(selectedMovie.getTitle());
    }

    public void cancelTicket(Ticket t) {
        CancelTicketView view = vc.createCancelTicketView(t);

        view.addCancelListener((ActionEvent e) -> {
            mainAppView();
        });

        view.addConfirmListener((ActionEvent e) -> {
            Ticket ticketToCancel = view.getTicket();
            Coupon c = tc.cancelTicket(ticketToCancel.getTicketID(), currentUser);
            em.emailTicketCancellation("todo@todo.com", c);
            mainAppView();
        });
    }

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
                    cancelTicket(ticketToCancel);
                } else {
                    vc.displayMessage("No Ticket was found.");
                }
            }
        });
    }

    public void mainAppView() {
        MainAppView app = vc.createAppView();

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
