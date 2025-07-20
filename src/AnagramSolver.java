import java.io.*;
import java.util.*;

public class AnagramSolver {

    public static void play(Scanner scanner) {
        List<String> dictionary = loadDictionary("dictionary.txt");

        if (dictionary.isEmpty()) {
            System.out.println(" Error loading dictionary.");
            return;
        }

        while (true) {
            System.out.print("\nEnter a word to find anagrams: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (!input.matches("[a-z]+")) {
                System.out.println("\n Invalid input! Please enter a valid word.");
                continue;
            }

            List<String> anagrams = findAnagrams(input, dictionary);

            if (anagrams.isEmpty()) {
                System.out.println("\n No anagrams found.");
            } else {
                System.out.println("\n  Anagrams found: " + anagrams);
            }

            System.out.print("\n Do you want to try again? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Thank you for using the Anagram Solver!");
                break;
            }
        }
    }

    private static List<String> loadDictionary(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim().toLowerCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading dictionary file: " + e.getMessage());
        }
        return words;
    }

    private static List<String> findAnagrams(String input, List<String> dictionary) {
        List<String> result = new ArrayList<>();
        String sortedInput = sortString(input);

        for (String word : dictionary) {
            if (!word.equals(input) && sortString(word).equals(sortedInput)) {
                result.add(word);
            }
        }
        return result;
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
