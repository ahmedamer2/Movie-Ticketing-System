package model;

/**
 * This class represents the coupon
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Coupon {
    private double value;
    private String couponID;

    /**
     * This is the constructor of the Coupon which takes in the value of a coupon 
     * and creates a Coupon
     * @param value value of the coupon
     */
    public Coupon(double value) {
        this.value = value;
        this.couponID = Randomizer.generateRandomString(9);
    }

    // Getters and Setters

    /**
     * getter functons that returns the value of the required Coupon
     * @return returns a value of coupon of type double
     */
    public double getValue() {
        return value;
    }

    /**
     * setter function which sets the value of the Coupon to the 
     * value passed as an argument
     * @param value the value for the Coupon
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * getter function to which returns id of the coupon
     * @return String representing the coupon id 
     */
    public String getCouponID() {
        return couponID;
    }
}
