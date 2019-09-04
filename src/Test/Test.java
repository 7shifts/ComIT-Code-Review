package Test;


import Main.PasswordVerifier;

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
        String qualityuppercase = "THUV89KBN";

//        yo not too familiar in writing good tests but here goes

//pasword length testing
        try {
            passwordverifer.passwordminLength(tooshort);

        } catch (Exception e) {
            System.out.println("password legnth exceptions = working");
        }
        try {
            passwordverifer.passwordminLength(nineCharLowercase);
        } catch (Exception e) {
            System.out.println("Password length has errors");
        }


        // pasword not null testing¬
        try {
            passwordverifer.passwordnotnull(null);
        } catch (Exception e) {
            System.out.println("null check works");
        }

        try {
            passwordverifer.passwordnotnull(blank);
        } catch (Exception e) {
            System.out.println("password blank check works ");
        }

//has uppercase testing
        try {
            passwordverifer.passwordhasUppercase(uppercase);
        } catch (Exception e) {
            System.out.println("not detecting uppercase ");
        }
        try {
            passwordverifer.passwordhasUppercase(lowercase);
        } catch (Exception e) {
            System.out.println("Uppercase check works");
        }
//has lowercase testing
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
//has digit testing
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
        //Verify testing
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
            if (passwordverifer.Verify(goodbutshort)) ;
            System.out.println("good short password passes");
        } catch (Exception e) {
            System.out.println("password not strong enough");
        }
        try {
            if (passwordverifer.Verify(qualityuppercase) == false) ;
            System.out.println("no lowercase will always fail");
        } catch (Exception e) {
            System.out.println("password not strong enough");
        }
        try{
            if(passwordverifer.Verify(uppercase)){
                System.out.println("verify isn't working");
            }
        }catch (Exception e) {
            System.out.println( e + " verify check is working");
        }

    }
}

//If each check took 1 second could make the not null check faster by only checking for null and allowing blank to be caught by length/lowercase/uppercase checks.
//for the uppercase check I could get
