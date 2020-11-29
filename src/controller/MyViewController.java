package controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;
import model.Movie;
import model.RegisteredUser;
import model.Ticket;

public class MyViewController {
    JFrame mainFrame;
    JPanel currentPanel = null;

    public MyViewController() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Ticket Registration System");
        mainFrame.setVisible(true);
    }

    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(mainFrame, msg);
    }

    public RegisterView createRegisterView() {
        removeCurrentPanel();
        RegisterView register = new RegisterView();
        currentPanel = register;
        mainFrame.add(register);
        mainFrame.pack();
        return register;
    }

    public CancelTicketView createCancelTicketView(Ticket t, boolean isRegistered) {
        removeCurrentPanel();
        CancelTicketView cancelView = new CancelTicketView(t, isRegistered);
        currentPanel = cancelView;
        mainFrame.add(cancelView);
        mainFrame.pack();
        return cancelView;
    }

    public TicketSearchView createTicketSearchView() {
        removeCurrentPanel();
        TicketSearchView searchView = new TicketSearchView();
        currentPanel = searchView;
        mainFrame.add(searchView);
        mainFrame.pack();
        return searchView;
    }

    public MainAppView createAppView(RegisteredUser u) {
        removeCurrentPanel();
        MainAppView app = new MainAppView(u);
        currentPanel = app;
        mainFrame.add(app);
        mainFrame.pack();
        return app;
    }

    public MovieView createMovieView(ArrayList<Movie> movies, boolean isRegistered) {
        removeCurrentPanel();
        MovieView movieView = new MovieView(movies, isRegistered);
        currentPanel = movieView;
        mainFrame.add(movieView);
        mainFrame.pack();
        return movieView;
    }

    public MainView createMainView() {
        removeCurrentPanel();
        MainView main = new MainView();
        currentPanel = main;
        mainFrame.add(main);
        mainFrame.pack();
        return main;
    }

    public LoginView createLoginView() {
        removeCurrentPanel();
        LoginView loginView = new LoginView();
        currentPanel = loginView;
        mainFrame.add(loginView);
        mainFrame.pack();
        return loginView;
    }

    public void removeCurrentPanel() {
        if (currentPanel != null)
            mainFrame.remove(currentPanel);
    }
}
