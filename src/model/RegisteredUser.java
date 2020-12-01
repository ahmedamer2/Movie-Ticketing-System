package model;

import java.util.ArrayList;

/**
 * This class represents a user which is already registered and stores all the various details of 
 * that registered user
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class RegisteredUser {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> purchasedTickets;
    private ArrayList<Coupon> coupons;

    /**
     * This is a constructor of Registered User which is takes in all the details of the RegisteredUser 
     * and makes a new RegisteredUser
     * @param email String representing the email id of the RegisteredUser
     * @param password String representing the password for the email id of the RegisteredUser
     * @param firstName String representing the first name of the RegisteredUser
     * @param lastName String representing the last name of the RegisteredUser
     */
    public RegisteredUser(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        purchasedTickets = new ArrayList<Ticket>();
        coupons = new ArrayList<Coupon>();
    }

    /**
     * this function adds the Ticket purchased by the Registered User to the Array List purchasedTickets
     * containing all the Ticket(s) purchased by the RegisteredUser
     * @param t this is a variable of type Ticket which represents the Ticket purchased by the 
     * RegisteredUser
     */
    public void addTicket(Ticket t) {
        purchasedTickets.add(t);
    }

    /**
     * this function removes the Ticket cancelled by the Registered User from the Array List purchasedTickets
     * containing all the Ticket(s) purchased by the RegisteredUser
     * @param t this is a variable of type Ticket which represents the Ticket cancelled by the 
     * RegisteredUser
     */
    public void removeTicket(Ticket t) {
        purchasedTickets.remove(t);
    }

    /**
     * this function adds the Coupon got by the Registered User to the Array List coupons
     * containing all the Coupon(s) acquired by the RegisteredUser
     * @param c this is a variable of type Coupon which represents the Coupon acquired by the 
     * RegisteredUser
     */
    public void addCoupon(Coupon c) {
        coupons.add(c);
    }

    /**
     * this function removes the Coupon that the Registered User has used from the Array List coupons
     * containing all the Coupon(s) acquired by the RegisteredUser
     * @param c this is a variable of type Coupon which represents the Coupon already used by the 
     * RegisteredUser
     */
    public void removeCoupon(Coupon c) {
        coupons.remove(c);
    }

    // Getters and Setters
    /**
     * getter function used to get the email of the RegisteredUser
     * @return returns String representing the email of the RegisteredUser
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter function used to get the password of the email of the RegisteredUser
     * @return returns String representing the password of the email of the RegisteredUser
     */
    public String getPassword() {
        return password;
    }

    /**
     * getter function used to get the first name of the RegisteredUser
     * @return returns String representing the firstName of the RegisteredUser
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getter function used to get the last name of the RegisteredUser
     * @return returns String representing the lastName of the RegisteredUser
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * getter function used to get the Coupon(s) acquired by the RegisteredUser
     * @return returns ArrayList representing the Coupon(s) acquired by the RegisteredUser
     */
    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    /**
     * getter function used to get the Ticket(s) purchased by the RegisteredUser
     * @return returns ArrayList representing the Ticket(s) purchased by the RegisteredUser
     */
    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }
}
