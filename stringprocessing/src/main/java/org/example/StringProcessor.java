package org.example;

import java.util.Scanner;

public class StringProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        // Validate that the entered password is not empty
        if (password.isEmpty()) {
            System.out.println("Please enter a non-empty password.");
            return;
        }

        StringProcessor stringProcessor = new StringProcessor();
        PasswordStrengthInfo strengthInfo = stringProcessor.calculatePasswordStrength(password);

        // Display password strength and criteria usage percentages
        System.out.println("Password Strength: " + strengthInfo.getStrength() + "%");
        System.out.println("Uppercase letters: " + strengthInfo.isUpperCaseUsed() + "%");
        System.out.println("Lowercase letters: " + strengthInfo.isLowerCaseUsed() + "%");
        System.out.println("Digits: " + strengthInfo.isDigitUsed() + "%");
        System.out.println("Special characters: " + strengthInfo.isSpecialCharUsed() + "%");
    }


    public PasswordStrengthInfo calculatePasswordStrength(String password) {
        // Initialize strength and criteria usage percentages
        int strength = 0;
        int upperCasePercentage = 0;
        int lowerCasePercentage = 0;
        int digitPercentage = 0;
        int specialCharPercentage = 0;

        // Check for the presence of an uppercase letter
        if (password.matches(".*[A-Z].*")) {
            strength += 25;
            upperCasePercentage = 25;
        }

        // Check for the presence of a lowercase letter
        if (password.matches(".*[a-z].*")) {
            strength += 25;
            lowerCasePercentage = 25;
        }

        // Check for the presence of a digit
        if (password.matches(".*\\d.*")) {
            strength += 25;
            digitPercentage = 25;
        }

        // Check for the presence of a special character
        if (password.matches(".*[@$!%*?&].*")) {
            strength += 25;
            specialCharPercentage = 25;
        }

        // Return a PasswordStrengthInfo object with calculated percentages
        return new PasswordStrengthInfo(strength, upperCasePercentage, lowerCasePercentage, digitPercentage, specialCharPercentage);
    }

    // Inner class to store information about password strength
    private static class PasswordStrengthInfo {
        private final int strength;
        private final int upperCasePercentage;
        private final int lowerCasePercentage;
        private final int digitPercentage;
        private final int specialCharPercentage;

        public PasswordStrengthInfo(int strength, int upperCasePercentage, int lowerCasePercentage, int digitPercentage, int specialCharPercentage) {
            this.strength = strength;
            this.upperCasePercentage = upperCasePercentage;
            this.lowerCasePercentage = lowerCasePercentage;
            this.digitPercentage = digitPercentage;
            this.specialCharPercentage = specialCharPercentage;
        }

        public int getStrength() {
            return strength;
        }

        public int isUpperCaseUsed() {
            return upperCasePercentage;
        }

        public int isLowerCaseUsed() {
            return lowerCasePercentage;
        }

        public int isDigitUsed() {
            return digitPercentage;
        }

        public int isSpecialCharUsed() {
            return specialCharPercentage;
        }
    }
}
