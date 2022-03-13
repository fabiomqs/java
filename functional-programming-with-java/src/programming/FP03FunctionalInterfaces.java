package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


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

		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		//corresponding Predicate
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}

		};

		Function<Integer, Integer> squareFunction = x -> x * x;
		//corresponding Function
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}

		};

		Consumer<Integer> sysoutConsumer = System.out::println;
		//corresponding Consumer
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

		numbers.stream()
				.filter(isEvenPredicate2)
				.map(squareFunction2)
				.forEach(sysoutConsumer2);

		//numbers.stream()
					//comment 01 - lambda expression represent a method
		//		.filter(x -> x%2==0)
					//comment 02
		//		.map(x -> x*x)
				//.forEach(x -> System.out.println(x));
		//		.forEach(System.out::println);


		//Exercise 12
		//Find Functional Interface behind the second argument of reduce method.
		// Create an implementation for the Functional Interface.
		//int sum = numbers.stream()
		//		.reduce(0, Integer::sum);

		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		//BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;

		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				return a + b;
			}
		};

		int sum = numbers.stream()
				.reduce(0, sumBinaryOperator2);

	}
}
