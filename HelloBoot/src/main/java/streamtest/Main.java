package streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7);
		
		numberList.stream()
		.map(number -> number * 2)
		.collect(Collectors.toList())
		.forEach(System.out::println);

	}

}
