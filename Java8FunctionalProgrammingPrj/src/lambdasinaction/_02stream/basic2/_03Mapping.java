package lambdasinaction._02stream.basic2;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import lambdasinaction._02stream.basic1.Dish;

public class _03Mapping {

    public static void main(String...args){

        //1. map -Dish의 name 목록만
    	List<String> dishNames = Dish.menu
    							.stream()
//    							.map(dish -> dish.getName())
    							.map(Dish::getName)
    							.collect(toList());
    	dishNames.forEach(System.out::println);
    	
    	// Dish의 칼로리 합계 계산
    	int sumOfCalory = Dish.menu
							.stream() // Stream<Dish>
							.map(Dish::getCalories) // Stream<Integer>
							.reduce((prev, curr) -> prev + curr) // Optional<Integer>
							.get(); // Integer
    	
    	System.out.println("Sum=" + sumOfCalory);
		
    	sumOfCalory = Dish.menu
				.stream() // Stream<Dish>
				.map(Dish::getCalories) // Stream<Integer>
				.reduce(0, (prev, curr) -> prev + curr); // Integer
    	System.out.println("Sum=" + sumOfCalory);


        // map 
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        //2. map - 중복된 문자 제거한 word 리스트
        System.out.println( words.stream() // Stream<String>
        		.map(word -> word.split(""))// Stream<String[]>
        		.distinct()
        		.collect(toList()));

        //3.flatMap  - 중복된 문자 제거가 word 리스트
        System.out.println("---------");

//        words.stream()// Stream<String>
//        .map(word -> word.split(""))// Stream<String[]>
//        .flatMap(strArr -> Arrays.stream(strArr))// Stream<String>
//        .distinct()
//		.collect(toList()));
        
        words.stream()
        	.flatMap(word -> Arrays.stream(word.split("")))
        	.distinct()
        	.collect(toList())
        	.forEach(System.out::println);




        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
