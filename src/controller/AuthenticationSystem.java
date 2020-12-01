package controller;

import model.RegisteredUser;

/**
 * This class manages any authentication needed for logging in or registering
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class AuthenticationSystem {
    /**
     * Uses database to verify user credentials
     * 
     * @param email the email of the user
     * @param pass  the password of the user
     * @return The user object if a user with the credentials was found, null
     *         otherwise
     */
    public RegisteredUser verifyCredentials(String email, String pass) {
        DBManager db = DBManager.getInstance();
        RegisteredUser user = db.getUser(email);
        if (user == null || !user.getPassword().equals(pass))
            return null;
        return user;
    }

    /**
     * Registeres a new user into the database
     * 
     * @param user the user to add
     * @return true if the registration was succeful, false otherwise
     */
    public boolean registerNewUser(RegisteredUser user) {
        DBManager db = DBManager.getInstance();
        return db.addUser(user);
    }
}
