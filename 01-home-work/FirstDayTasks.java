import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstDayTasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words;
        do {
            System.out.println("Enter a line of text:");
            words = Arrays.stream(scanner.nextLine()
                            .replaceAll("[^\\p{L}\\p{N}]+", " ")
                            .split("\\s+"))
                    .map(String::toLowerCase)
                    .toList();
        } while (words.isEmpty());

        words.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey()));

    }
}
