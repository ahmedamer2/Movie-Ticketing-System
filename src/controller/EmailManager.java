package controller;

import model.Coupon;
import model.Ticket;

public class EmailManager {
    public void emailTicketPurchase(String email, Ticket ticket, double amount) {
        System.out.println("\n----------------------------------");
        System.out.println("To: " + email);
        System.out.println("Subject: Ticket Purchase");
        System.out.println("Thank you for purchasing a ticket!");
        System.out.println("You saved $" + (ticket.getSeat().getPrice() - amount) + " by using your coupon!");
        System.out.println("You paid $" + amount + " for this ticket.");

        System.out.println("Here is the Ticket Info: ");
        System.out.println(ticket.toString());
        System.out.println("\nYou can cancel this ticket within 72 hours of this email");
        System.out.println("----------------------------------\n");
    }

    public void emailTicketCancellation(String email, Coupon coupon) {
        System.out.println("\n----------------------------------");
        System.out.println("To: " + email);
        System.out.println("Subject: Ticket Cancellation");
        System.out.println("This is your Coupon ID for the cancelled Ticket: ");
        System.out.println(coupon.getCouponID());
        System.out.println("Redeem this Coupon when purchasing a ticket to get a reduced price!");
        System.out.println("----------------------------------\n");
    }

    public void emailRegistration(String email) {
        System.out.println("\n----------------------------------");
        System.out.println("To: " + email);
        System.out.println("Subject: User Registration");
        System.out.println("Thank you for becoming a Registered User!");
        System.out.println("----------------------------------\n");
    }
}
