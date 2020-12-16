package com.fkd.oop.task;
/*
find unique and unique Even numbers in two arrays
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueEvenNum {
    public static void main(String[] args) {


        List<Integer> listNumbers = Arrays.asList(3, 9, 1, 8, 15, 15, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6, 12);
        List<Integer> listNumbers_2 = Arrays.asList(3, 8, 9, 1, 3,3, 9, 1, 8, 15, 15, 4, 7, 2, 5, 8, 6, 12);

        System.out.println("List<Integer> listNumbers: " + '\n'+ '\t' + listNumbers);
        Set<Integer> uniqueNumbers = new HashSet<>(listNumbers);
        System.out.println("unique numbers of List<Integer> listNumbers: " + '\n' + '\t'+ uniqueNumbers);


        Set<Integer> uniqueEvenNumbers = listNumbers_2.stream()
                .filter(number -> number % 2 == 0).collect(Collectors.toSet());

        System.out.println("uniqueEvenNumbers for List<Integer> listNumbers & List<Integer> listNumbers_2: " + '\n' + '\t'+ uniqueEvenNumbers);

    }
}