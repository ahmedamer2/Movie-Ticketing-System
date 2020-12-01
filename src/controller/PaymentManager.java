package controller;

import java.util.ArrayList;
import model.Payment;

/**
 * This class manages all of the theatre's payments including ticket purchases
 * and cancellations
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class PaymentManager {
    ArrayList<Payment> theatrePayments;

    /**
     * Contructor for th epayment manager
     * 
     * @param payments the list of payments retreived from the database
     */
    public PaymentManager(ArrayList<Payment> payments) {
        this.theatrePayments = payments;
    }

    /**
     * Processes a theatre payment
     * 
     * @param payment the payment to process
     * @return if the payment was successful
     */
    public boolean processPayment(Payment payment) {
        // Simulate processing a payment
        DBManager db = DBManager.getInstance();
        theatrePayments.add(payment);
        db.addPayment(payment);
        payment.setPending(false);
        payment.setPaid(true);
        return true;
    }
}
