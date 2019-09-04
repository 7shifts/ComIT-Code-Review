package main;

import java.util.regex.Pattern;

public class PasswordVerifier {
    private Pattern textPattern;

    public PasswordVerifier() {
        textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

    }

    public void verify() {

    }

    public boolean isLargerThanEight(String password) {
        return password.length() > 8;
    }

    public boolean isNotNull(String password) {
        return password != null;
    }

    public boolean containsUppercase(String password) {
        Pattern uppercasePattern = Pattern.compile("^(?=.*[A-Z]).+$");
        return uppercasePattern.matcher(password).matches();
    }

    public boolean containsLowercase(String password) {
        Pattern lowercasePattern = Pattern.compile("^(?=.*[a-z]).+$");
        return lowercasePattern.matcher(password).matches();
    }

    public boolean containsDigit(String password) {
        Pattern digitPattern = Pattern.compile("^(?=.*\\d).+$");
        return digitPattern.matcher(password).matches();
    }
}
