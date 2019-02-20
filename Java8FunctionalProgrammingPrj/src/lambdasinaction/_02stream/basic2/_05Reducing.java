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
    	
        //reduce - - reduce�� ����Ͽ� sum �� ���ϴ� ���

        //reduce�� ����Ͽ� �ּҰ� ���ϴ� ���

        //reduce�� ����Ͽ� �ִ밪 ���ϴ� ���
        int maxValue = numbers.stream().reduce(0, Integer::max);
        System.out.println("max1=" + maxValue);
        
//        maxValue = numbers.stream().reduce(Integer::max).get();
        
        Optional<Integer> optVal = numbers.stream().reduce(Integer::max);
        optVal.ifPresent(System.out::println);
        maxValue = optVal.get();
        
        System.out.println("max2=" + maxValue);
        		

        //Į�θ� �հ踦 ���ϴ� �������� ���
        // 1.  reduce() �޼ҵ带 ��������
        int sumOfCalory1 = menu.stream()
        					.map(d -> d.getCalories()) // Stream<Integer>
        					.reduce((prev, curr) -> prev+curr) // Optional<Integer>
        					.get();
        
        // 2. reduce()���� Integer.sum() ȣ��
        int sumOfCalory2 = menu.stream()
        					.map(Dish::getCalories) // Stream<Integer>
        					.reduce(0, Integer::sum); // Integer
//        					.reduce(0,  (p,c) -> Integer.sum(p, c))
        
        // 3. reduce ��ſ� mapToInt�� ���� IntStream�� ����� IntStream�� sum() ȣ��
        int sumOfCalory3 = menu.stream()
        					.mapToInt(Dish::getCalories) // IntStream
        					.sum();
        
       
        System.out.println("sumOfCalory1=" + sumOfCalory1);
        System.out.println("sumOfCalory2=" + sumOfCalory2);
        System.out.println("sumOfCalory3=" + sumOfCalory3);
        
        // IntStream�� summaryStatistics() ���
        System.out.println(
        		IntStream.range(1, 101).summaryStatistics()
        		);
    }
}
