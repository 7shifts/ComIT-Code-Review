package main;

import java.util.regex.Pattern;

public class PasswordVerifier {

    public PasswordVerifier() {

    }

    public boolean verify(String password) {
        int numValid = 0;

        // password is never OK if item 1.4 (password should have one lowercase letter at least) is not true.
        try {
            if (containsLowercase(password)) numValid++;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }

        try {
            if (isNotNull(password)) numValid++;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            if (isLargerThanEight(password)) numValid++;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        if (numValid == 3) return true; // for optimization

        try {
            if (containsUppercase(password)) numValid ++;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        if (numValid == 3) return true; // for optimization

        try {
            if (containsDigit(password)) numValid ++;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        return numValid == 3;

        /*
            Optimization:
            - The containsLowercase() function is executed first.
              If a password doesn't contain lowercase, we can return false and skip the other validations.

            - Returns true whenever the value of numValid is three.
              The if statements are added after the function#3 and #4 are executed.

         */
    }

    public boolean isLargerThanEight(String password) throws IllegalArgumentException {
        Boolean isValidPassword = (password != null) && (password.length() > 8);

        if (!isValidPassword)
            throw new IllegalArgumentException("Password length has to be greater than 8.");

        return true;
    }

    public boolean isNotNull(String password) throws IllegalArgumentException {
        Boolean isValidPassword = (password != null);

        if (!isValidPassword)
            throw new IllegalArgumentException("Password cannot be blank.");

        return true;
    }

    public boolean containsUppercase(String password) throws IllegalArgumentException {
        Pattern uppercasePattern = Pattern.compile("^(?=.*[A-Z]).+$");
        Boolean isValidPassword = (password != null) && uppercasePattern.matcher(password).matches();

        if (!isValidPassword)
            throw new IllegalArgumentException("Password should have at least one uppercase letter.");

        return true;
    }

    public boolean containsLowercase(String password) throws IllegalArgumentException {
        Pattern lowercasePattern = Pattern.compile("^(?=.*[a-z]).+$");
        Boolean isValidPassword = (password != null) && lowercasePattern.matcher(password).matches();

        if (!isValidPassword)
            throw new IllegalArgumentException("Password should have at least one lowercase letter.");

        return true;
    }

    public boolean containsDigit(String password) throws IllegalArgumentException {
        Pattern digitPattern = Pattern.compile("^(?=.*\\d).+$");
        Boolean isValidPassword = (password != null) && digitPattern.matcher(password).matches();

        if (!isValidPassword)
            throw new IllegalArgumentException("Password should contain at least one number.");

        return true;
    }
}
