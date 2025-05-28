package org.example.stream;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Test_stream {
    @Test
    public void filter(){
        String[] arr = {"Apple", "Banana", "Orange", "Pear", "Grape", "Mango"};
        System.out.println(Arrays.toString(arr));
        String[] res = Arrays.stream(arr).sequential().filter(s -> s.startsWith("A")).toArray(String[]::new);
        System.out.println(Arrays.toString(res));
        //
        List<String> list = new ArrayList<>(List.of(arr));
        System.out.println(list);
        List<String> filterList = list.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        System.out.println("filter: " + filterList);
        //
        List<String> mapList = list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
                //.toList();
        System.out.println("map: " + mapList);
        //
        List<String> flatMapList = list.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .collect(Collectors.toList());
        System.out.println("flatMap: " + flatMapList);
        //
        List<String> sortList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted: " + sortList);
        //
        List<String> limitedList = list.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("limit: " + limitedList);
        //
        List<String> skippedList = list.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("skip: " + skippedList);
        //
        List<String> distinctList = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct: " + distinctList);
        //
        boolean anyMatch = list.stream()
                .anyMatch(s -> s.contains("a"));
        System.out.println("anyMatch: " + anyMatch);
        //
        Optional<String> reduced = list.stream()
                .reduce((s1, s2) -> s1 + "-" + s2);
        System.out.println(reduced);
        //
        Map<Integer, List<String>> groupedMap = list.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedMap);
    }
}
