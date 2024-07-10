package com.rapifuzz.assignment.utility;

import java.time.Year;
import java.util.Random;

public class SimpleRandomNumberGenerator implements RandoNumberGenerator{
    private static final String PREFIX = "RMG";
    private static final int RANDOM_DIGITS = 5;
    @Override
    public String generateNumber() {
        int year = Year.now().getValue();
        return PREFIX + generateFiveDigitNumber() + year;
    }
    private String generateFiveDigitNumber() {
        Random random = new Random();

        // Generate a random number between 0 to 99999 (inclusive)
        int randomNum = random.nextInt(100000);
        // Generates numbers from 0 to 99999

        // Ensure it's a 5-digit number by adding leading zeros if necessary
        return String.format("%05d", randomNum);
    }

}
