package model;

import java.util.ArrayList;

public class RegisteredUser {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> purchasedTickets;
    private ArrayList<Coupon> coupons;

    public RegisteredUser(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        purchasedTickets = new ArrayList<Ticket>();
        coupons = new ArrayList<Coupon>();
    }

    public void addTicket(Ticket t) {
        purchasedTickets.add(t);
    }

    public void removeTicket(Ticket t) {
        purchasedTickets.remove(t);
    }

    public void addCoupon(Coupon c) {
        coupons.add(c);
    }

    public void removeCoupon(Coupon c) {
        coupons.remove(c);
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }
}
