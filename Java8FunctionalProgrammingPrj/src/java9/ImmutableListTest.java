package java9;

import java.util.List;

public class ImmutableListTest {

	public static void main(String[] args) {
		List<String> list = List.of("java","scala","python");
		list.add("javascript");
		
		System.out.println(list);
	}

}
