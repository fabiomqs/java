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
		//filterAndPrint(numbers, x -> x%2==0);
		//filterAndPrint(numbers, x -> x%2!=0);
		//filterAndPrint(numbers, x -> x%3==0);

		//Exercise 13
		//Do Behavior Parameterization for the mapping logic.
		//		List<Integer> squaredNumbers =  numbers.stream()
		//		.map(x -> x*x)
		//		.collect(Collectors.toList());
		List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x*x);
		List<Integer> cubedNumbers =  mapAndCreateNewList(numbers, x -> x*x*x);
		List<Integer> doubledNumbers =  mapAndCreateNewList(numbers, x -> x + x);

		System.out.println("squaredNumbers: " + squaredNumbers);
		System.out.println("cubedNumbers: " + cubedNumbers);
		System.out.println("doubledNumbers: " + doubledNumbers);
	}

	private static List<Integer> mapAndCreateNewList(
			List<Integer> numbers,
			Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
				.map(mappingFunction)
				.collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}

}
