package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		int sum = addListFunctional(numbers);

		System.out.println(sum);

	}

	//functional sum using reduce
	private static int addListFunctional(List<Integer> numbers) {
		//Stream of number -> One result value
		//Combine them into one result => One Value
		// 0 and FP02Functional::sum
		return numbers.stream()
				.reduce(0, FP02Functional::sum);

	}

	private static int sum(int aggregate, int nextNumber) {

		return aggregate + nextNumber;
	}
	

}
