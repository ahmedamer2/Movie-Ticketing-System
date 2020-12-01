package model;

/**
 * This class represents all the details of the Payment that is made by a user 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Payment {
    private double amount;
    private String senderCardID;
    private String receiverCardID;
    private boolean isPaid;
    private boolean isPending;

    /**
     * This is the conctructor of the class Payment which takes in all the various details of 
     * the payment and creates a new Payment 
     * @param amount this is the amount of the payment which sender pays of type double
     * @param senderCardID String representing the sender's card ID 
     * @param receiverCardID String representing the receiver's card ID
     */
    public Payment(double amount, String senderCardID, String receiverCardID) {
        this.amount = amount;
        this.senderCardID = senderCardID;
        this.receiverCardID = receiverCardID;
        this.isPaid = false;
        this.isPending = false;
    }

    // Getters and Setters
    /**
     * getter function used to get the amount of the Payment
     * @return returns the amount of the payment of type double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * getter function used to get the senderCardID of the Payment
     * @return returns String representing the sender's card ID
     */
    public String getSenderCardID() {
        return senderCardID;
    }

    /**
     * getter function used to get the recieverCardID of the Payment
     * @return returns String representing the reciever's card ID
     */
    public String getReceiverCardID() {
        return receiverCardID;
    }

    /**
     * this function tells if the payment is paid or not by returning isPaid variable in Payment 
     * @return returns a boolean(true/false) depending upon if the payment is paid(true) or
     * not(false)
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * this function tells if the payment is pending or not by returning isPending variable in Payment 
     * @return returns a boolean(true/false) depending upon if the payment is pending(true) or
     * not(false)
     */
    public boolean isPending() {
        return isPending;
    }

    /**
     * setter function used to set the value of isPaid to the isPaid of type boolean passed as an argument
     * @param isPaid variable of type boolean representing if the payment is paid or not
     */
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * setter function used to set the value of isPending to the isPending of type boolean passed as an argument
     * @param isPending variable of type boolean representing if the payment is pending or not
     */
    public void setPending(boolean isPending) {
        this.isPending = isPending;
    }
}
