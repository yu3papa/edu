package java9;

import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		Stream.of(1,2,3,4,5,6,7,8,9)
				.takeWhile(i -> i < 5)
				.forEach(System.out::println);
		
		System.out.println("-------------");
		Stream.of(1,2,3,4,5,6,7,8,9)
		.dropWhile(i -> i < 5)
		.forEach(System.out::println);

	}

}
