package controller;

import java.util.ArrayList;
import java.awt.event.ActionEvent;

import view.*;
import model.*;

public class ApplicationController {
    TicketController tc;
    PaymentManager pm;
    AuthenticationSystem auth;
    ArrayList<Movie> movieList;
    RegisteredUser currentUser;
    MyViewController vc;

    public ApplicationController() {
        DBManager db = DBManager.getInstance();
        tc = new TicketController(db.getTickets(), db.getCoupons());
        pm = new PaymentManager(db.getPayments());
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
                    // Go To Main View (after logging)
                    vc.displayMessage("Login Successful");
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
            System.out.println("view not implemented yet");
        });
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.appEntry();
    }
}
