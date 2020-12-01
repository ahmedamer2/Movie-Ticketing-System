package controller;

import model.Coupon;
import model.Ticket;

/**
 * This class manages all email communcation with Ordinary and Registered users
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class EmailManager {
    /**
     * Sends an email regarding a ticket purchase and the ticket information
     * 
     * @param email  the email to send to
     * @param ticket the ticket that the email is about
     * @param amount the amount paid for the ticket
     */
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

    /**
     * Sends an email regarding a ticket cancellation
     * 
     * @param email  the email to send to
     * @param coupon the coupon for the cancellation
     */
    public void emailTicketCancellation(String email, Coupon coupon) {
        System.out.println("\n----------------------------------");
        System.out.println("To: " + email);
        System.out.println("Subject: Ticket Cancellation");
        System.out.println("This is your Coupon ID for the cancelled Ticket: " + coupon.getCouponID());
        System.out.println("Redeem this Coupon when purchasing a ticket to get a reduced price!");
        System.out.println("----------------------------------\n");
    }

    /**
     * Sends an email regarding a new user registration
     * 
     * @param email the email to send to
     */
    public void emailRegistration(String email) {
        System.out.println("\n----------------------------------");
        System.out.println("To: " + email);
        System.out.println("Subject: User Registration");
        System.out.println("Thank you for becoming a Registered User!");
        System.out.println("----------------------------------\n");
    }
}
