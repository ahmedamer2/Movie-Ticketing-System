package model;

public class Payment {
    private double amount;
    private int senderCardID;
    private int receiverCardID;
    private boolean isPaid;
    private boolean isPending;

    public Payment(double amount, int senderCardID, int receiverCardID) {
        this.amount = amount;
        this.senderCardID = senderCardID;
        this.receiverCardID = receiverCardID;
        this.isPaid = false;
        this.isPending = false;
    }

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public int getSenderCardID() {
        return senderCardID;
    }

    public int getReceiverCardID() {
        return receiverCardID;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setPending(boolean isPending) {
        this.isPending = isPending;
    }
}
