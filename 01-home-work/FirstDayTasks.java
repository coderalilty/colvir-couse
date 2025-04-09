import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstDayTasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        List<String> words = Arrays.stream(sentence
                        .replaceAll("[^\\p{L}\\p{N}]+", " ")
                        .split("\\s+"))
                .map(String::toLowerCase)
                .toList();
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey()));

    }
}
