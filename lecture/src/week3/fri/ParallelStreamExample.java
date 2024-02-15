package week3.fri;

import java.util.*;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        //List 컬렉션 생성
        List<String> list = new ArrayList< >();
        list.add("Jason");
        list.add("John");
        list.add("Zoe");
        list.add("Bob");
        list.add("Steven");

        //병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach( name -> {
            System.out.println(name + ": " + Thread.currentThread().getName());
        } );
    }
}