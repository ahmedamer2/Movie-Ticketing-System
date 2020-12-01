package model;

import java.util.ArrayList;
import java.util.Random;

import controller.TicketController;

public class Randomizer {
    static String chars = "abcdefghijklmnopqrstuvwxyz1234567890";

    static String generateRandomString(int count) {
        StringBuilder res = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            char c = chars.charAt(rand.nextInt(chars.length()));
            res.append(c);
        }

        return res.toString();
    }

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
