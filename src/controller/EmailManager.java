package controller;

import model.Coupon;
import model.Ticket;

public class EmailManager {
    public void emailTicketPurchase(String email, Ticket ticket) {
        // implement this
    }

    public void emailTicketCancellation(String email, Coupon coupon) {
        System.out.println("To: " + email);
        System.out.println("Subject: Ticket Cancellation");
        System.out.println("This is your Coupon ID for the cancelled Ticker: ");
        System.out.println(coupon.getCouponID());
        System.out.println("Redeem this Coupon when purchasing a ticket to get a reduced price!");
    }

    public void emailRegistration(String email, Coupon coupon) {
        // implement this
    }
}
