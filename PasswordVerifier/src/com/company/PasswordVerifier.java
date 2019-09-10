public class PasswordVerifier {

    public static void main(String[] args) {
        String pass = "abdsdscdEF";
        System.out.println("Password is : "+pass);
        try {
            System.out.println("Response is : "+verify(pass));
        } catch (InvalidPasswordException e) {
            System.out.println("Response is : "+e.getMessage());
        }
    }

    public static String verify(String pass) throws InvalidPasswordException {
        int count=0;
        boolean isupper=false;
        boolean isdigit = false;
        if(pass==null || pass.trim().isEmpty() || pass.length()<8) {
            throw new InvalidPasswordException("Password must contains atleast 8 characters");
        }else {
            count++;
        }
        if(!pass.matches("(.*)[a-z](.*){1,}")) {
            throw new InvalidPasswordException("Password must contains atleast one lowercase letter");
        }else {
            count++;
        }
        if(pass.matches("(.*)[A-Z](.*){1,}")) {
            count++;
            isupper=true;
        }
        if(pass.matches("(.*)[0-9](.*){1,}")) {
            count++;
            isdigit=true;
        }
        if(count < 3 && !isupper){
            throw new InvalidPasswordException("Password must contains atleast one uppercase letter");
        }else if(count>=3 && !isupper) {
            throw new InvalidPasswordException("Password seems OK but atleast one uppercase letter will make it strong");
        }
        if(count < 3 && !isdigit) {
            throw new InvalidPasswordException("Password must contains atleast one numeric character");
        }else if(count >= 3 && !isdigit) {
            throw new InvalidPasswordException("Password is OK but atleast one numeric character will make it strong");
        }
        return "OK";
    }
}
class NotAStrongPasswordException extends Exception {
    public NotAStrongPasswordException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

//OUTPUT :
//
//        Password is :
//        Response is : Password must contains atleast 8 characters
//
//        Password is : abc
//        Response is : Password must contains atleast 8 characters
//
//        Password is : ABCDEFGH
//        Response is : Password must contains atleast one lowercase letter
//
//        Password is : abcdefgh
//        Response is : Password must contains atleast one uppercase letter
//
//        Password is : abcdEFGH
//        Response is : Password is OK but atleast one numeric character will make it strong
//
//        Password is : abcd1234
//        Response is : Password is OK but atleast one uppercase letter will make it strong
//
//        Password is : abcd1ABC
//        Response is : OK
