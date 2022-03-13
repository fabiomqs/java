package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//Problem:
		//print the even then the odd numbers but there is code repetition
		//numbers.stream()
		//		.filter(x -> x%2==0)
		//		.forEach(System.out::println);
		//
		//numbers.stream()
		//		.filter(x -> x%2!=0)
		//		.forEach(System.out::println);

		//Solution
		filterAndPrint(numbers, x -> x%2==0);
		filterAndPrint(numbers, x -> x%2!=0);
		
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}

}
