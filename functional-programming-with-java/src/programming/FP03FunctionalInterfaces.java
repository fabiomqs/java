package programming;

import java.util.List;


public class FP03FunctionalInterfaces {

	/*
	 comment 01
	 boolean isEven(int x) {
	 	return x%2==0;
	 }

	 comment 02
	 int squared(int x) {
	 	return x * x;
	 }
	 */

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		numbers.stream()
					//comment 01 - lambda expression represent a method
				.filter(x -> x%2==0)
					//comment 02
				.map(x -> x*x)
				//.forEach(x -> System.out.println(x));
				.forEach(System.out::println);

	}
}
