package model;

public class Coupon {
    private double value;
    private String couponID;

    public Coupon(double value) {
        this.value = value;
        this.couponID = Randomizer.generateRandomString(9);
    }

    // Getters and Setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCouponID() {
        return couponID;
    }
}
