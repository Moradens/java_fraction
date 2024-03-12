import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TextProcessor {
    private List<String> words;
    private Map<String, Integer> wordCounts;

    public TextProcessor() {
        words = new ArrayList<>();
        wordCounts = new HashMap<>();
    }

    public void addWord(String word) {
        word = word.trim();
        words.add(word);
        word = word.toLowerCase();
        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    public List<String> getOriginalText() {
        return words;
    }

    public List<String> getUniqueWords() {
        return new ArrayList<>(wordCounts.keySet());
    }

    public int getUniqueWordCount() {
        return wordCounts.size();
    }

    public int getWordFrequency(String word) {
        word = word.toLowerCase();
        return wordCounts.getOrDefault(word, 0);
    }

    public String getShortestWord() {
        String shortest = "";
        for (String word : words) {
            if (shortest.isEmpty() || word.length() < shortest.length()) {
                shortest = word;
            }
        }
        return shortest;
    }

    public String getLongestWord() {
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}

public class words {
    public static void main(String[] args) {
        TextProcessor processor = new TextProcessor();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Vkládejte slova (konec = ukončení):");
        String word = scanner.nextLine();
        while (!word.equalsIgnoreCase("konec")) {
            processor.addWord(word);
            word = scanner.nextLine();
        }
        System.out.println("Původní text: " + processor.getOriginalText());
        System.out.println("Unikátní slova: " + processor.getUniqueWords());
        System.out.println("Počet unikátních slov: " + processor.getUniqueWordCount());

        System.out.print("Zadejte slovo pro zjištění jeho počtu výskytů: ");
        word = scanner.nextLine();
        System.out.println("Počet výskytů slova \"" + word + "\": " + processor.getWordFrequency(word));

        System.out.println("Nejkratší slovo: " + processor.getShortestWord());
        System.out.println("Nejdelší slovo: " + processor.getLongestWord());

        scanner.close();
    }
}

