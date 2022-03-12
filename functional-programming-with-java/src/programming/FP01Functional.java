package programming;

import java.util.List;

//loop in functional approach
public class FP01Functional { 
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		 printAllNumbersInListFunctional(numbers);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// What to do?
		//convert the list into a stream of numbers
		numbers.stream()
		//for each on stream of numbers passing method reference
		//		.forEach(FP01Functional::print);// Method Reference
		//change the reference method to use directly from the classSystem.out
				.forEach(System.out::println);// Method Reference

	}

	//private static void print(int number) {
	//	System.out.println(number);
	//}

}
