package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {

	public static void main(String[] args) throws IOException {
//		read the lines of the file
//		Files.lines(Paths.get("file.txt"))
//				.forEach(System.out::println);

//		print all the distinct words in the file
//		Files.lines(Paths.get("file.txt"))
//				.map(str -> str.split(" "))
//				.flatMap(Arrays::stream)
//				.distinct()
//				.sorted()
//				.forEach(System.out::println);

//		list all the directories
		Files.list(Paths.get("."))
			.filter(Files::isDirectory)
			.forEach(System.out::println);

	}

}
