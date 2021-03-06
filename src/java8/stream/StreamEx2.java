package java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("jeong", "pro", "jdk", "Java");
        //기존 코딩 방식
        long count = 0;
        for (String name : names) {
            if (name.contains("o")) {
                count++;
            }
        }
        System.out.println("Count : " + count);

        //스트림 이용한 방식
        count = 0;
        count = names.stream().filter(x -> x.contains("o")).count();
        System.out.println("Count : " + count);

        names.stream(); //Colltection에서 스트림 생성

        Double[] dArra = {3.1, 3.2, 3.3};
        Arrays.stream(dArra); //배열로 스트림 생성

        //중개 연산
        //Filter
        Stream<String> a = names.stream().filter(x -> x.contains("o"));

        //Map
        names.parallelStream().map((x) -> {
            return x.concat("s");
        }).forEach(x -> System.out.println(x));

        //Limit
        List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ages.stream().filter(x -> x > 3).limit(3).forEach(x -> System.out.println(x));

        //최종연산
        //reduce
        ArrayList<Integer> ages1 = new ArrayList<>();
        ages1.add(1);
        ages1.add(2);
        ages1.add(3);
        System.out.println(ages1.stream().reduce((x, y) -> x + y).get());

        //forEach
        Set<Integer> set = ages1.stream().collect(Collectors.toSet());
        set.forEach(x -> System.out.println(x));

        //iterator
        Iterator<String> iter = names.stream().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //noneMatch, anyMatch, allMatch
        System.out.println(ages1.stream().filter(x -> x > 1).noneMatch(x -> x > 2));
    }
}
