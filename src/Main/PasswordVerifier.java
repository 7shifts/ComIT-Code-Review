package Main;

public class PasswordVerifier {


    public boolean Verify(String password) throws Exception {
        boolean validpass = false;
        boolean  haslowercase = false;
        int passwordstrength = 0;
        try {
            if (passwordnotnull(password)) {
                passwordstrength = passwordstrength + 1;
            }
            if (passwordhasLowercase(password)) {
                haslowercase = true;
                passwordstrength = passwordstrength + 1;
            }
            if (passwordHasNumber(password)) {
                passwordstrength = passwordstrength + 1;
            }
            if (passwordminLength(password)) {
                passwordstrength = passwordstrength + 1;
            }
            if (passwordhasUppercase(password)) {
                passwordstrength = passwordstrength + 1;
            }

        } catch (Exception e) {
            throw new Exception( e + "verify has failed");
        }
        if (passwordstrength >= 3 & validpass) {
            validpass = true;
        }
        return validpass;
    }


    public Boolean passwordminLength(String password) throws Exception {
        if (password.length() <= 8) {
            throw new Exception("password to short");
        }
        return true;
    }


    public Boolean passwordnotnull(String password) throws Exception {
        if (password == null || password.isBlank()) {
            throw new Exception("password cannot be null");
        } else
            return true;
    }

    public Boolean passwordhasUppercase(String password) throws Exception {

        for (int i = 0; i <= password.length(); i++) {
            Character currentCharacter = password.charAt(i);
            if (Character.isUpperCase(currentCharacter)) {
                break;
            }
            if (i == password.length()) {
                throw new Exception(("password has no uppercase"));
            }
        }
        return true;
    }

    public Boolean passwordhasLowercase(String password) throws Exception {

        for (int i = 0; i <= password.length(); i++) {
            Character currentCharacter = password.charAt(i);
            if (Character.isLowerCase(currentCharacter)) {
                break;
            }
            if (i == password.length()) {
                throw new Exception(("password has no lowercase"));
            }
        }
        return true;
    }

    public boolean passwordHasNumber(String password) throws Exception {
        for (int i = 0; i <= password.length(); i++) {
            Character currentCharacter = password.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                break;
            }
            if (i == password.length()) {
                throw new Exception(("password contains no digits"));
            }
        }
        return true;
    }


}


