package test;

import main.PasswordVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordVerifierTest {
    private PasswordVerifier tester = new PasswordVerifier();
    @Test
    void verify() {

    }

    @Test
    void isLargerThanEight() {
        assertEquals(false,tester.isLargerThanEight("abc"));
        assertEquals(false,tester.isLargerThanEight("abcd5678"));
        assertEquals(true,tester.isLargerThanEight("abcd56789"));
        assertEquals(true,tester.isLargerThanEight("1234567890"));
    }

    @Test
    void isNotNull() {
        assertEquals(true, tester.isNotNull("abc"));
        assertEquals(true, tester.isNotNull(""));
        assertEquals(true, tester.isNotNull("null"));
        assertEquals(false, tester.isNotNull(null));
    }

    @Test
    void containsUppercase() {
        assertEquals(true, tester.containsUppercase("7Shift"));
        assertEquals(true, tester.containsUppercase("7shifT"));
        assertEquals(true, tester.containsUppercase("Shift7"));
        assertEquals(false, tester.containsUppercase("7shift"));
        assertEquals(false, tester.containsUppercase("7777777"));
        assertEquals(false, tester.containsUppercase(""));
    }

    @Test
    void containsLowercase() {
        assertEquals(true, tester.containsLowercase("7Shift"));
        assertEquals(true, tester.containsLowercase("7shifT"));
        assertEquals(true, tester.containsLowercase("Shift7"));
        assertEquals(false, tester.containsLowercase("7SHIFT"));
        assertEquals(false, tester.containsLowercase("7777777"));
        assertEquals(false, tester.containsLowercase(""));

    }

    @Test
    void containsDigit() {
        assertEquals(true, tester.containsDigit("7Shift"));
        assertEquals(true, tester.containsDigit("7shifT"));
        assertEquals(true, tester.containsDigit("Shift7"));
        assertEquals(false, tester.containsDigit("SevenShift"));
        assertEquals(true, tester.containsDigit("7777777"));
        assertEquals(false, tester.containsDigit(""));
    }
}