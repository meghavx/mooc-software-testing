package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {

    @Test
    public void singleNumber() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void singleSymbol() {
        RomanNumeral roman = new RomanNumeral();
        String result = roman.convert(1);
        Assertions.assertEquals("I", result);
    }

    @Test
    public void symbolWithManyChars() {
        RomanNumeral roman = new RomanNumeral();
        String result = roman.convert(8);
        Assertions.assertEquals("VIII", result);
    }

    @Test
    public void symbolWithSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        String result = roman.convert(4);
        Assertions.assertEquals("IV", result);
    }

    @Test
    public void symbolWithAndWithoutSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        String result = roman.convert(44);
        Assertions.assertEquals("XLIV", result);
    }

    @Test
    public void testWith5000() {
        RomanNumeral roman = new RomanNumeral();
        String result = roman.convert(5000);
        Assertions.assertEquals("MMMMM", result);
    }

    @Test
    public void testWith6000() {
        RomanNumeral roman = new RomanNumeral();
        String result = roman.convert(6000);
        Assertions.assertEquals("MMMMMM", result);
    }
}
