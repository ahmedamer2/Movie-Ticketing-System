import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;

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
