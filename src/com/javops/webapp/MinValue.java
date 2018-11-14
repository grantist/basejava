package com.javops.webapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MinValue {
    public static void main(String[] args) {
        int[] values = {8, 8, 8, 8};
        System.out.println(minValues(values));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(oddOrEven(list));
    }

    public static int minValues(int[] values) {
        return IntStream.of(values).distinct().sorted().reduce(0, (a, b) -> 10 * a + b);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {

        return integers.stream().filter(x -> (x % 2) == (integers.stream().mapToInt(Integer::intValue).sum() % 2)).collect(Collectors.toList());

    }
}