package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Seat;
import model.ShowTime;

public class SeatView extends JPanel {
    JButton[] seatButtons = new JButton[100];
    JButton cancelButton;
    JLabel[] labels = new JLabel[10];
    JLabel screenHere = new JLabel();
    ShowTime st;

    public SeatView(ShowTime st) {
        this.st = st;
        initComponents();

        ArrayList<Seat> seatList = st.getSeatList();
        for (int i = 0; i < seatList.size(); i++) {
            seatButtons[i].setEnabled(seatList.get(i).isAvailable());
        }
    }

    private void initComponents() {
        setPreferredSize(new Dimension(850, 480));
        setLayout(null);
        setBackground(new Color(255, 153, 204));

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

    public void addBackListener(java.awt.event.ActionListener e) {
        cancelButton.addActionListener(e);
    }

    public void addSeatListeners(ArrayList<java.awt.event.ActionListener> e) {
        for (int i = 0; i < e.size(); i++) {
            seatButtons[i].addActionListener(e.get(i));
        }
    }

    public Seat getSeat(int index) {
        return st.getSeatList().get(index);
    }
}
