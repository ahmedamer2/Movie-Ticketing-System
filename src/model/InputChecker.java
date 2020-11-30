package model;

import java.util.regex.Pattern;

/**
 * This class is used for checking if the input entered the user is valid or not 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class InputChecker {
    // From: https://www.geeksforgeeks.org/check-email-address-valid-not-java/

    /**
     * This functions checks if the email id entered by the user is valid or not
     * @param email email id of the user to be checked of type String
     * @return returns a boolean(true/false) depending upon whether the email
     * of type String is valid(true) or not(false)  
     */
    public static boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /**
     * This functions checks if the account number of the user's bank account
     * entered by the user is valid or not
     * @param number String representing the account number of the user's bank account 
     * @param count int representing the number of digits that should be in valid 
     *user's bank account number 
     * @return returns a boolean(true/false) depending if the account number of type String has
     * required number of dihits and then if it is valid(true) or not(false)  
     */
    public static boolean checkNumber(String number, int count) {
        if (number.length() != count)
            return false;

        for (char c : number.toCharArray()) {
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }
}
