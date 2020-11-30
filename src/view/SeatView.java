package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Seat;
import model.ShowTime;

/**
 * The SeatView class is a class extending JPanel used to present the seat view to the user.
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet
 * @version 1.0
 * @since November 29, 2020
 */
public class SeatView extends JPanel {
    //JPanel components and member variables
    JButton[] seatButtons = new JButton[100];
    JButton cancelButton;
    JLabel[] labels = new JLabel[10];
    JLabel screenHere = new JLabel();
    ShowTime st;

    /**
     * The Constructor for the SeatView which takes in a ShowTime object needed to present the seatView for that specific show time. It will also call the 
     * initComponents method used to initialize the JPanel components and add them appropriately
     * @param st The ShowTime object used by the SeatView
     */
    public SeatView(ShowTime st) {
        this.st = st;
        initComponents();

        ArrayList<Seat> seatList = st.getSeatList();
        for (int i = 0; i < seatList.size(); i++) {
            seatButtons[i].setEnabled(seatList.get(i).isAvailable());
        }
    }

    /**
     * The initComponents method is used to initialize, format, resize and setup all the JPanel components.
     */
    private void initComponents() {
        //setup JPanel
        setPreferredSize(new Dimension(850, 480));
        setLayout(null);
        setBackground(new Color(255, 153, 204));

        //Initialize and assign Components
        screenHere = new JLabel("SCREEN HERE");
        screenHere.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        screenHere.setSize(100, 50);

        cancelButton = new JButton("Back");
        cancelButton.setSize(100, 20);
        cancelButton.setLocation(20, 430);
        cancelButton.setBackground(new java.awt.Color(255, 204, 204));
        cancelButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        cancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cancelButton);

        int x;
        int y = 50;
        char c = 'A';
        int rows = st.getRowCapacity();
        int cols = st.getColCapacity();
        for (int i = 0; i < rows; i++) {
            c = 'A';
            x = 120;
            labels[i] = new JLabel("Row " + i);
            labels[i].setSize(50, 20);
            add(labels[i]);
            labels[i].setLocation(x - 50, y + 25);

            for (int j = 0; j < cols; j++) {
                seatButtons[i * cols + j] = new JButton();
                seatButtons[i * cols + j].setText(Character.toString(c));
                seatButtons[i * cols + j].setSize(55, 55);
                add(seatButtons[i * cols + j]);
                seatButtons[i * cols + j].setLocation(x, y);
                x += 65;
                c++;
            }
            y += 65;
        }
        add(screenHere);
        screenHere.setLocation(360, y + 30);
        setVisible(true);
    }

    /**
     * The addBackListener method takes in an ActionListener to be added to the backButton which will listen
     * for the user to press the backButton.
     * @param e The ActionListener that will be used to listen for the cancelButton to be pressed.
     */
    public void addBackListener(java.awt.event.ActionListener e) {
        cancelButton.addActionListener(e);
    }

    /**
     * The addSeatListener method takes in an ArrayList of type ActionListener to be a added to the buttons representing each seat. The Listeners will 
     * listen to the appropriate button and wait for the user to click on it.
     * @param e The ArrayList of type ActionListener used to listen to the seats.
     */
    public void addSeatListeners(ArrayList<java.awt.event.ActionListener> e) {
        for (int i = 0; i < e.size(); i++) {
            seatButtons[i].addActionListener(e.get(i));
        }
    }

    /**
     * The getter getSeat is used to return the Seat the user picked at a given index.
     * @param index The index of the chosen seat
     * @return An object of type Seat representing the seat that the user picked.
     */
    public Seat getSeat(int index) {
        return st.getSeatList().get(index);
    }
}
