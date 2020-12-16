package com.fkd.oop.task;
/*
Sum of two polynomials
 */

import java.util.*;

public class SumOfPolynomials {
    public static void main(String[] args) {
        Map<Integer, Integer> plynomial1 = new HashMap<Integer, Integer>() {
            {
                put(0, 5);
                put(1, 3);
                put(3, 2);
                put(5, 4);
                put(6, 7);
            }
        };
        Map<Integer, Integer> plynomial2 = new HashMap<Integer, Integer>() {
            {
                put(0, 5);
                put(3, 4);
                put(5, 5);
                put(6, 1);
            }
        };

        System.out.println("Plynomial_1: -> " + convertToString(plynomial1));
        System.out.println("Plynomial_2: -> " + convertToString(plynomial2));
        System.out.println("Plynomial_1 + Plynomial_2: -> " + convertToString(sum(plynomial1,plynomial2)));

    }

    public static Map<Integer, Integer> sum(Map<Integer, Integer> polynomial1,
                                            Map<Integer, Integer> polynomial2) {
        int koef;
        Map<Integer, Integer> sumPolynoms = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry1 : polynomial1.entrySet()){
            koef = entry1.getKey();
            for(Map.Entry<Integer, Integer> entry2 : polynomial2.entrySet()) {
                if (koef == entry2.getKey())
                    sumPolynoms.put(koef, entry1.getValue()+entry2.getValue());
                if(!polynomial2.containsKey(koef))
                    sumPolynoms.put(koef, entry1.getValue());
            }
        }
        return sumPolynoms;
    }

    static  String convertToString(Map<Integer, Integer> map) {
        Map<Integer, Integer> toStringResult = new TreeMap<>(Comparator.reverseOrder());
        toStringResult.putAll(map);

        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : toStringResult.entrySet()) {
            String value = entry.getKey() == 0
                    ? String.valueOf(entry.getValue())
                    : entry.getValue() + "x^" + entry.getKey();
            list.add(value);
        }
        return String.join(" + ", list);
    }
}


