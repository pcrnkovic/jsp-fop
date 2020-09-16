/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.function;

import java.util.TreeMap;

/**
 *
 * @author Pavle Crnković
 */
public class RomanNumberCalculator {

    private final static TreeMap<Integer, String> map;

    static {
        map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    
    public static String toRoman(int number) {
        synchronized (RomanNumberCalculator.class) {
            if (!map.containsKey(number)) {
                return toRomanHelper(number);
            }
        }
        return map.get(number);
    }
    
    private final static String toRomanHelper(int number) {
        if (!map.containsKey(number)) {
            int low = map.floorKey(number);
            map.put(number, map.get(low) + toRomanHelper(number - low));
        }
        return map.get(number);
    }

}
