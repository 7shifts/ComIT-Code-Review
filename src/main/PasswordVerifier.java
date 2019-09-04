package main;

import java.util.regex.Pattern;

public class PasswordVerifier {

    public PasswordVerifier() {

    }

    public boolean verify(String password) {
        return false;
    }

    public boolean isLargerThanEight(String password) throws IllegalArgumentException {
        Boolean isValidPassword = password.length() > 8;

        if (!isValidPassword)
            throw new IllegalArgumentException("Error: Password length has to be greater than 8.");

        return true;
    }

    public boolean isNotNull(String password) throws IllegalArgumentException {
        Boolean isValidPassword = (password != null);

        if (!isValidPassword)
            throw new IllegalArgumentException("Error: Password cannot be blank.");

        return true;
    }

    public boolean containsUppercase(String password) throws IllegalArgumentException {
        Pattern uppercasePattern = Pattern.compile("^(?=.*[A-Z]).+$");
        Boolean isValidPassword = uppercasePattern.matcher(password).matches();

        if (!isValidPassword)
            throw new IllegalArgumentException("Error: Password should have at least one uppercase letter.");

        return true;
    }

    public boolean containsLowercase(String password) throws IllegalArgumentException {
        Pattern lowercasePattern = Pattern.compile("^(?=.*[a-z]).+$");
        Boolean isValidPassword = lowercasePattern.matcher(password).matches();

        if (!isValidPassword)
            throw new IllegalArgumentException("Error: Password should have at least one lowercase letter.");

        return true;
    }

    public boolean containsDigit(String password) throws IllegalArgumentException {
        Pattern digitPattern = Pattern.compile("^(?=.*\\d).+$");
        Boolean isValidPassword = digitPattern.matcher(password).matches();

        if (!isValidPassword)
            throw new IllegalArgumentException("Error: Password should contain at least one number.");

        return true;
    }
}
