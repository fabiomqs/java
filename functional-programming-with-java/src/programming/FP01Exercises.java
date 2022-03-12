package programming;

import java.util.List;

public class FP01Exercises { 
	
	public static void main(String[] args) {
		//List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses =
				List.of("Spring", "Spring Boot", "API" , "Microservices",
						"AWS", "PCF","Azure", "Docker", "Kubernetes");

		//Exercise 1
		//Print Only Odd Numbers from the List
		//printOddNumbersInListFunctional(numbers);

		//Exercise 2
		//Print All Courses individually
		//courses.stream().forEach(System.out::println);

		//Exercise 3
		//Print Courses Containing the word "Spring"
		courses.stream()
				.filter(course -> course.contains("Spring"))
				.forEach(System.out::println);
	}

	// number -> number%2 != 0
	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream() // Convert to Stream
				.filter(number -> number % 2 != 0) // Lamdba Expression
				.forEach(System.out::println);// Method Reference
	}

}
