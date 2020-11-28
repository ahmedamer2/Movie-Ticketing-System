package model;

public class Coupon {
    private double value;
    private String couponID;

    public Coupon(double value, String couponID) {
        this.value = value;
        this.couponID = couponID;
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
