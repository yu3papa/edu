package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import lambdasinaction._02stream.basic1.Dish;
import static lambdasinaction._02stream.basic1.Dish.menu;


public class _05Reducing {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    	
        //reduce - - reduce를 사용하여 sum 을 구하는 방법

        //reduce를 사용하여 최소값 구하는 방법

        //reduce를 사용하여 최대값 구하는 방법
        int maxValue = numbers.stream().reduce(0, Integer::max);
        System.out.println("max1=" + maxValue);
        
//        maxValue = numbers.stream().reduce(Integer::max).get();
        
        Optional<Integer> optVal = numbers.stream().reduce(Integer::max);
        optVal.ifPresent(System.out::println);
        maxValue = optVal.get();
        
        System.out.println("max2=" + maxValue);
        		

        //칼로리 합계를 구하는 여러가지 방법
        // 1.  reduce() 메소드를 직접구현
        int sumOfCalory1 = menu.stream()
        					.map(d -> d.getCalories()) // Stream<Integer>
        					.reduce((prev, curr) -> prev+curr) // Optional<Integer>
        					.get();
        
        // 2. reduce()에서 Integer.sum() 호출
        int sumOfCalory2 = menu.stream()
        					.map(Dish::getCalories) // Stream<Integer>
        					.reduce(0, Integer::sum); // Integer
//        					.reduce(0,  (p,c) -> Integer.sum(p, c))
        
        // 3. reduce 대신에 mapToInt를 통해 IntStream을 만들고 IntStream의 sum() 호출
        int sumOfCalory3 = menu.stream()
        					.mapToInt(Dish::getCalories) // IntStream
        					.sum();
        
       
        System.out.println("sumOfCalory1=" + sumOfCalory1);
        System.out.println("sumOfCalory2=" + sumOfCalory2);
        System.out.println("sumOfCalory3=" + sumOfCalory3);
        
        // IntStream의 summaryStatistics() 사용
        System.out.println(
        		IntStream.range(1, 101).summaryStatistics()
        		);
    }
}
