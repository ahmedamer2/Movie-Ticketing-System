package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Seat;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SeatView {
    JFrame frame;
    JPanel panel;
    JButton[] bJButtons = new JButton[100];
    JButton cancel;
    JButton confirm;
    JLabel[] labels = new JLabel[10];
    JLabel sc = new JLabel();
    int a = 0, b = 0;
    int x, y;
    ArrayList<Seat> seats;

    public SeatView(ArrayList<Seat> s) {
        seats = s;
    }

    public void start() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 480);
        frame.setLayout(null);
        panel = new JPanel();
        panel.setSize(840, 470);
        panel.setLayout(null);
        panel.setBackground(Color.green);

        sc = new JLabel("SCREEN HERE");
        sc.setSize(100, 50);

        confirm = new JButton("Confirm Seats");
        confirm.setSize(100, 20);
        confirm.setLocation(730, 430);
        panel.add(confirm);

        cancel = new JButton("Cancel");
        cancel.setSize(100, 20);
        cancel.setLocation(20, 430);
        panel.add(cancel);

        x = 10;
        y = 10;
        char c = 'A';
        for (int i = 0; i < 5; i++) {
            c = 'A';
            y += 65;
            x = 70;
            labels[i] = new JLabel("Row " + Integer.toString(5 - i));
            labels[i].setSize(50, 20);
            panel.add(labels[i]);
            labels[i].setLocation(x - 50, y + 25);

            for (int j = 0; j < 10; j++) {
                bJButtons[i * 10 + j] = new JButton();
                bJButtons[i * 10 + j].setText(Character.toString(c));
                bJButtons[i * 10 + j].setSize(55, 55);
                panel.add(bJButtons[i * 10 + j]);
                bJButtons[i * 10 + j].setLocation(x, y);

                x += 65;
                c++;
            }

        }
        /*
         * bJButtons[10].addActionListener(new ActionListener() { public void
         * actionPerformed(ActionEvent e) {
         * //statusLabel.setText("Ok Button is clicked here");
         * System.out.println("seat is 9a"); } });
         */

        for (a = 0; a < 5; a++) {
            System.out.println(a);
            for (b = 0; b < 10; b++) {
                addListener(bJButtons[(a * 10) + b], a, b);

            }
        }

        panel.add(sc);
        sc.setLocation(350, y + 80);

        frame.add(panel);
        panel.setVisible(true);
        frame.setVisible(true);
    }

    void addListener(JButton button, int a, int b) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                booked(button);
                System.out.println("Row " + Integer.toString(10 - a) + "seat " + (char) (((int) 'A') + b));

            }
        });
    }

    void setStatus() {

    }

    void booked(JButton button) {
        button.setText("X");

    }

    // public static void main(String[] args) {
    // ArrayList<Seat> sList = new ArrayList<Seat>();

    // for (int i = 0; i < 5; i++) {
    // for (int j = 0; j < 10; j++) {
    // Seat seat = new Seat(i, j, 20);
    // sList.add(seat);
    // }

    // }

    // SeatView s = new SeatView(sList);
    // s.start();

    // }
}