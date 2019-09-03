public class Test {
    public static void main(String[] args) {
        PasswordVerifier passwordverifer = new PasswordVerifier();
        String tooshort = "short";
        String blank = " ";
        String nineCharLowercase = "weakpassword";
        String uppercase = "ALLUPPERCASE";
        String lowercase = "alllowercase";
        String mixedcase = "MiXeDcAsE";
        String numpass = "123456789";
        String Qualitypass = "ThuV89kBN";
        String goodbutshort = "ThuV8";
        String threegoodqualities = "longer789";


//        yo never written tests before here goes//

//pasword length
        try {
            passwordverifer.passwordminLength(tooshort);
            passwordverifer.passwordminLength(threegoodqualities);
            passwordverifer.passwordminLength(blank);
        } catch (Exception e) {
            System.out.println("password legnth exceptions = working");
        }
        try {
            passwordverifer.passwordminLength(nineCharLowercase);
        } catch (Exception e) {
            System.out.println("Password length has errors");
        }
        // pasword not null
        try {
            passwordverifer.passwordnotnull(null);
        } catch (Exception e) {
            System.out.println("null check works");
        }

        try {
            passwordverifer.passwordnotnull(tooshort);
        } catch (Exception e) {
            System.out.println("password null doesn't work ");
        }
//has uppercase
        try {
            passwordverifer.passwordhasUppercase(uppercase);
        } catch (Exception e) {
            System.out.println("not detecting uppercase ");
        }
        try {
            passwordverifer.passwordhasUppercase(tooshort);
        } catch (Exception e) {
            System.out.println("Uppercase check works");
        }
//has lowercase
        try {
            passwordverifer.passwordhasLowercase(nineCharLowercase);
        } catch (Exception e) {
            System.out.println("not detecting lowercase ");
        }
        try {
            passwordverifer.passwordhasLowercase(uppercase);
        } catch (Exception e) {
            System.out.println("Lowercase check works");
        }
//has digit

        try {
            passwordverifer.passwordHasNumber(numpass);
        } catch (Exception e) {
            System.out.println("Number check has errors ");
        }
        try {
            passwordverifer.passwordHasNumber(uppercase);
        } catch (Exception e) {
            System.out.println("Number check is working");
        }
        try {
            if (passwordverifer.Verify(Qualitypass)) {
                System.out.println("Quality pass passes");
            }
        } catch (Exception e) {
            System.out.println("password not strong enough");
        }
        try {
            if (passwordverifer.Verify(threegoodqualities)) {
                System.out.println("3 strength pass passes");
            }
        } catch (Exception e) {
            System.out.println("password not strong enough");
        }
        try {
            passwordverifer.Verify(goodbutshort);
        } catch (Exception e) {
            System.out.println("password not strong enough");
        }
        try {
            passwordverifer.Verify(tooshort);
        } catch (Exception e) {
            System.out.println("password not strong enough");
        }
        try {
            passwordverifer.Verify(uppercase);
        } catch (Exception e) {
            System.out.println(e + "casued issues");
        }

    }

}


