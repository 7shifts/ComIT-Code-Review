public class PasswordVerifier {
    public void Verify(String password) throws Exception {
        try{
            passwordminLength(password);
            passwordnotnull(password);
            passwordhasUppercase(password);
//            passwordhasLowercase(password);
//            passwordHasNumber(password);
        }catch (Exception e){
            System.out.println(e + "caused issues");
        }
    }


    public void passwordminLength(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("password to short");
        }
    }


    public void passwordnotnull(String password) throws Exception {
        if (password == null) {
            throw new Exception("password cannot be null");
        }
    }

    public void passwordhasUppercase(String password) throws Exception {
        Boolean hasUppercase = false;
        for (int i = 0; i <= password.length(); i++) {
            Character currentCharacter = password.charAt(i);
            if (Character.isUpperCase(currentCharacter)) {
                hasUppercase = true;
                break;
            }
            if (i == password.length()) {
                throw new Exception(("password has no uppercase"));
            }
        }
    }
    public void passwordhasLowercase(String password) throws Exception{
        Boolean hasLowercase = false;
        for (int i = 0; i <= password.length(); i++) {
            Character currentCharacter = password.charAt(i);
            if (Character.isLowerCase(currentCharacter)) {
                hasLowercase = true;
                break;
            }
            if (i == password.length()) {
                throw new Exception(("password has no lowercase"));
            }
        }
    }

    public void passwordHasNumber(String password) throws Exception{
        Boolean hasNumber = false;
        for (int i = 0; i <= password.length(); i++) {
            Character currentCharacter = password.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                hasNumber = true;
                break;
            }
            if (i == password.length()) {
                throw new Exception(("password contains no digits"));
            }
        }
    }


}


