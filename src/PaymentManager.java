import java.util.ArrayList;

public class PaymentManager {
    ArrayList<Payment> theatrePayments;

    public PaymentManager(ArrayList<Payment> payments) {
        this.theatrePayments = payments;
    }

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
