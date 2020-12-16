package com.fkd.oop.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomToArabic {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any Roman numeral:");

        String rimnumber= bfr.readLine().toUpperCase();
        int arabcount = 0;

        for (int i = rimnumber.length()-1; i >= 0; i--) {
            char rim2 = rimnumber.charAt(i);
            if (i == 0) {
                arabcount += MapConvert(rim2);
                break;
            }
            char rim1 = rimnumber.charAt(i-1);
            if (MapConvert(rim2) > MapConvert(rim1)) {
                arabcount += (MapConvert(rim2) - MapConvert(rim1));
                i--;
            }
            else {
                arabcount += MapConvert(rim2);
            }
        }
        System.out.println("Roman numeral: " + rimnumber + ". The same Arabic: " + arabcount);
    }

    public static int MapConvert (char rim) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map.get(rim);
    }
}
