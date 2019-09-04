package test;

import main.PasswordVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordVerifierTest {
    private PasswordVerifier tester = new PasswordVerifier();
    @Test
    void verify() {

    }

    @Test
    void isLargerThanEight() {
        assertEquals(true,tester.isLargerThanEight("abcd56789"));
        assertEquals(true,tester.isLargerThanEight("1234567890"));
    }

    @Test
    void isLargerThanEightShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tester.isLargerThanEight("abc");
                    tester.isLargerThanEight("abcd5678");
                });
    }

    @Test
    void isNotNull() {
        assertEquals(true, tester.isNotNull("abc"));
        assertEquals(true, tester.isNotNull(""));
        assertEquals(true, tester.isNotNull("null"));
    }

    @Test
    void isNotNullShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tester.isNotNull(null);
                });
    }

    @Test
    void containsUppercase() {
        assertEquals(true, tester.containsUppercase("7Shift"));
        assertEquals(true, tester.containsUppercase("7shifT"));
        assertEquals(true, tester.containsUppercase("Shift7"));
    }

    @Test
    void containsUppercaseShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tester.containsUppercase("7shift");
                    tester.containsUppercase("7777777");
                    tester.containsUppercase("");
                });
    }

    @Test
    void containsLowercase() {
        assertEquals(true, tester.containsLowercase("7Shift"));
        assertEquals(true, tester.containsLowercase("7shifT"));
        assertEquals(true, tester.containsLowercase("Shift7"));
    }

    @Test
    void containsLowercaseShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tester.containsLowercase("7SHIFT");
                    tester.containsLowercase("7777777");
                    tester.containsLowercase("");
                });
    }

    @Test
    void containsDigit() {
        assertEquals(true, tester.containsDigit("7Shift"));
        assertEquals(true, tester.containsDigit("7shifT"));
        assertEquals(true, tester.containsDigit("Shift7"));
        assertEquals(true, tester.containsDigit("7777777"));
    }

    @Test
    void containsDigitShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tester.containsDigit("SevenShift");
                    tester.containsDigit("");
                });

    }
}