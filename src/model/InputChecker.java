package model;

import java.util.regex.Pattern;

public class InputChecker {
    // From: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    public static boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

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
