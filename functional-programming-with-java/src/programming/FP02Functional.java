package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//int sum = addListFunctional(numbers);
		//System.out.println(sum);

		//List<Integer> squaredNumbers = squareList(numbers);
		//System.out.println(squaredNumbers);

		//Exercise 10
		//Create a List with Even Numbers Filtered from the Numbers List
		List<Integer> evenNumbersOnly = numbers.stream()
				.filter(x -> x%2==0)
				.collect(Collectors.toList());
		System.out.println(evenNumbersOnly);

	}

	//using collect
	private static List<Integer> squareList(List<Integer> numbers) {
		return numbers.stream()
				.map(number -> number * number)
				.collect(Collectors.toList());
	}

	//functional sum using reduce
	private static int addListFunctional(List<Integer> numbers) {
		//Stream of number -> One result value
		//Combine them into one result => One Value
		// 0 and FP02Functional::sum
		return numbers.stream()
				//.reduce(0, FP02Functional::sum);
			//.reduce(0, (x,y) -> x+y); //using lambda
			.reduce(0, Integer::sum);//using Integer::sum

	}

//	private static int sum(int aggregate, int nextNumber) {
//		System.out.println(aggregate + " " + nextNumber);
//		return aggregate + nextNumber;
//	}
	

}
