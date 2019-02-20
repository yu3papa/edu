package lambdasinaction._01lambda.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class SortingUsingComparator {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("자바","스칼라", "하스켈","파이썬");
		
		//1. 익명클래스
		strList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(strList);
		
		// 2. 람다식
		strList.sort((s1,s2) -> s1.compareTo(s2));
		System.out.println(strList);
		
		// 3. Method Reference
		strList.sort(String::compareTo);
		System.out.println(strList);
		
		//4. Stream sort이용
		Stream<String> stream = strList.stream().sorted(String::compareTo);
		List<String> result = stream.collect(toList());
		System.out.println(result);
		
		System.out.println("================");
		strList.stream()
			.sorted(String::compareTo)
			.collect(toList())
			.forEach(System.out::println);
	}
}
