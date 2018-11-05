package com.project;

import java.util.Scanner;

public class Main {

    private static String city;
    private static String person;
    private static String pesel;

    private static String temp;

    private final static int[] validNumbers = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

    public static void main(String[] args) {
        System.out.println("Program wita");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            temp = scanner.nextLine();

            if (temp.split(" ").length == 2) {
                person = temp;
                System.out.println("Osoba: " + person);
                continue;
            }

            if (isNumeric(temp)) {
                if (checkPeselValidity(temp)) {
                    pesel = temp;
                    System.out.println("Pesel ok: " + pesel);
                }
            } else {
                city = temp;
                System.out.println("Siti propabli: " + city);
            }
        }
    }

    private static boolean checkPeselValidity(String pesel) {
        if (temp.length() != 11) {
            System.out.println("Nie ma 11 czarsow");
            return false;
        }
        int sum = 0;
        for (int i = 0; i < pesel.length() - 1; i++) {
            sum = sum + validNumbers[i] * Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }
        String stringSum = String.valueOf(sum);
        int lastSumDigit = Integer.parseInt(String.valueOf(stringSum.charAt(stringSum.length() - 1)));
        int lastPeselDigit = Integer.parseInt(String.valueOf(pesel.charAt(pesel.length() - 1)));
        if (lastPeselDigit == lastSumDigit ) {
            System.out.println("Pesel okej");
            return true;
        } else {
            System.out.println("Pesel zly");
            return false;
        }

    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
