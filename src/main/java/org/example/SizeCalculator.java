package org.example;

import java.io.File;
import java.util.HashMap;

public class SizeCalculator {
    private static final String[] SIZES = {"B", "Kb", "Mb", "Gb", "Tb"};

    private static HashMap<Character, Integer> charToMultiplier = getMultiplier();

    public static String getHumanReadableSize(long size) {
        int power = (int) (Math.log(size) / Math.log(1024));
        double value = size / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + " " + SIZES[power >=0 ? power : 0];
    }

    public static long getSizeFromHumanReadable(String size) {
        char sizeFactor = size.replaceAll("[0-9\\s+]+", "").charAt(0);
        int multiplier = charToMultiplier.get(sizeFactor);
        long length = multiplier * Long.valueOf(
                size.replaceAll("[^0-9]", "")
        );

        return length;

    }

    private static HashMap<Character, Integer> getMultiplier() {

        HashMap<Character, Integer> charToMultiplier = new HashMap<>();
        for (int i = 0; i < SIZES.length; i++) {
            charToMultiplier.put(SIZES[i].charAt(0), (int) Math.pow(1024, i));
        }
        return charToMultiplier;
    }
}
