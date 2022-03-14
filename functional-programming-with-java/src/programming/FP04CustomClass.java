package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClass {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		//*********************************************************************
		// allMatch, noneMatch, anyMatch
		//*********************************************************************
		System.out.println("allMatch, noneMatch, anyMatch");
		Predicate<Course> reviewScoreGreaterThan95Predicate
				= course -> course.getReviewScore() > 95;

		Predicate<Course> reviewScoreGreaterThan90Predicate
				= course -> course.getReviewScore() > 90;

		Predicate<Course> reviewScoreLessThan90Predicate
				= course -> course.getReviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

		//*********************************************************************

		System.out.println("--------------------------------------------------");

		//*********************************************************************
		//Class with sorted and creating comparators
		//*********************************************************************
		System.out.println("Class with sorted and creating comparators");
		//comparingInt is mor efficient than comparing because uses the primitive type
		Comparator<Course> comparingByNoOfStudentsIncreasing
				= Comparator.comparingInt(Course::getNoOfStudents);

		System.out.println(
				courses.stream()
						.sorted(comparingByNoOfStudentsIncreasing)
						.collect(Collectors.toList()));

		Comparator<Course> comparingByNoOfStudentsDecreasing
				= Comparator.comparingInt(Course::getNoOfStudents).reversed();

		System.out.println(
				courses.stream()
						.sorted(comparingByNoOfStudentsDecreasing)
						.collect(Collectors.toList()));

		//comparing with multiple properties
		//sort by NoOfStudents
		// if noOfStudents is the same sort by reviewScore
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews
				= Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore)
				.reversed();

		System.out.println(
				courses.stream()
						.sorted(comparingByNoOfStudentsAndNoOfReviews)
						.collect(Collectors.toList()));

		//*********************************************************************

		System.out.println("--------------------------------------------------");


		//*********************************************************************
		//skip, limit, takeWhile and dropWhile
		//*********************************************************************
		System.out.println("skip, limit, takeWhile and dropWhile");

		System.out.println(
				courses.stream()
						.sorted(comparingByNoOfStudentsAndNoOfReviews)
						.limit(5)
						.collect(Collectors.toList()));

		System.out.println(
				courses.stream()
						.sorted(comparingByNoOfStudentsAndNoOfReviews)
						.skip(3) //skip the first 3 courses
						.collect(Collectors.toList()));

		System.out.println(
				courses.stream()
						.sorted(comparingByNoOfStudentsAndNoOfReviews)
						.skip(3)
						.limit(5)
						.collect(Collectors.toList()));

		System.out.println(courses);

		System.out.println(
				courses.stream()
						//includes evething until match the criteria then drops evething else
						.takeWhile(course -> course.getReviewScore()>=95)
						.collect(Collectors.toList()));

		System.out.println(
				courses.stream()
						//drop evething until match the criteria
						.dropWhile(course -> course.getReviewScore()>=95)
						.collect(Collectors.toList()));

		//*********************************************************************

		System.out.println("--------------------------------------------------");


		//*********************************************************************
		//Finding top, max and min courses with max, min, findFirst and findAny
		//*********************************************************************
		System.out.println("Finding top, max and min courses with max, min, findFirst and findAny");

		System.out.println(
				courses.stream()
						//return the last element of the list after sort
						.max(comparingByNoOfStudentsAndNoOfReviews));

		System.out.println(
				courses.stream()
						//return the first element
						.min(comparingByNoOfStudentsAndNoOfReviews)
						.orElse(new Course("Kubernetes",
								"Cloud", 91, 20000)));

		System.out.println(
				courses.stream()
						.filter(reviewScoreLessThan90Predicate)
						.min(comparingByNoOfStudentsAndNoOfReviews)
						.orElse(new Course("Kubernetes",
								"Cloud", 91, 20000)));

		System.out.println(
				courses.stream()
						.filter(reviewScoreLessThan90Predicate)
						.findFirst());

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.collect(Collectors.toList()));

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.findFirst());

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.findAny());

		//*********************************************************************

		System.out.println("--------------------------------------------------");

		//*********************************************************************
		//sum, average and count
		//*********************************************************************
		System.out.println("sum, average and count");

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.sum());

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.average());

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.count());

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.max());

		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.min());

		//*********************************************************************

		System.out.println("--------------------------------------------------");


		//*********************************************************************
		//Grouping courses into Map using groupingBy
		//*********************************************************************
		System.out.println("Grouping courses into Map using groupingBy");


		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory)));
		//{ Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
		//  FullStack=[FullStack:14000:91],
		//  Microservices=[API:22000:97, Microservices:25000:96],
		//  Framework=[Spring:20000:98, Spring Boot:18000:95]}

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(
										Course::getCategory,
										Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//{ Cloud=Optional[Azure:21000:99],
		//  FullStack=Optional[FullStack:14000:91],
		//  Microservices=Optional[API:22000:97],
		//  Framework=Optional[Spring:20000:98]}

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(
										Course::getCategory,
										Collectors.mapping(Course::getName, Collectors.toList()))));
		//{ Cloud=[AWS, Azure, Docker, Kubernetes],
		//  FullStack=[FullStack],
		//  Microservices=[API, Microservices],
		//  Framework=[Spring, Spring Boot]}


		Predicate<Course> reviewScoreGreaterThan95Predicate2
				= createPredicateWithCutoffReviewScore(95);

		Predicate<Course> reviewScoreGreaterThan90Predicate2
				= createPredicateWithCutoffReviewScore(90);

		//*********************************************************************
	}

	private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
		return course -> course.getReviewScore() > cutoffReviewScore;
	}


}
