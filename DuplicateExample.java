package com.test.dcplicate;

import java.util.*;
import java.util.stream.*;

public class DuplicateExampleprintusedset{
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 20, 40, 10, 50, 30);

        Set<Integer> set = new HashSet<>();

        numbers.stream()
               .filter(n -> !set.add(n))
               .forEach(System.out::println);
    }
}
