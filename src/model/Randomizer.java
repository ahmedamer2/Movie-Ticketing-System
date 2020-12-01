package model;

import java.util.ArrayList;
import java.util.Random;

import controller.TicketController;

/**
 * This class is Randomizer used to generate coupon ID ,ticket ID and populate seats
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Randomizer {
    static String chars = "abcdefghijklmnopqrstuvwxyz1234567890";

    /**
     * This function is used generate Coupon ID or Ticket ID
     * @param count this is a variable of type int representing the number of digits in a coupon/ticket id 
     * @return returns a String representing the Coupon/Ticket id 
     */
    static String generateRandomString(int count) {
        StringBuilder res = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            char c = chars.charAt(rand.nextInt(chars.length()));
            res.append(c);
        }

        return res.toString();
    }

    /**
     * This function is used to populate the seats by creating Ticket(s) for some percentage of seats randomly 
     * by using TicketController
     * @param seatList this is an ArrayList of type Seat representing all the seats in a Theatre 
     * @param tc This is an object of type TicketController which is used to generate and store 
     * all the Ticket(s)
     * @param percent this is a variable of type int representing the percentage of tne Seat(s) that are 
     * occupied
     */
    public static void populateRandomSeats(ArrayList<Seat> seatList, TicketController tc, int percent) {
        if (percent < 0 || percent > 100)
            return;

        Random rand = new Random();
        for (Seat s : seatList) {
            if (rand.nextInt(100) < percent)
                tc.createTicket(s);
        }
    }
}
