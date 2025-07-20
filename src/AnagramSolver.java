import java.io.*;
import java.util.*;

public class AnagramSolver {

    public static void play(Scanner scanner) {
        List<String> dictionary = loadDictionary("dictionary.txt");

        if (dictionary.isEmpty()) {
            System.out.println("Error loading dictionary.");
            return;
        }

        Random random = new Random();

        while (true) {
            // Pick a random word from the dictionary
            String chosenWord = dictionary.get(random.nextInt(dictionary.size()));
            System.out.println("\nFind anagrams for the word: " + chosenWord);

            // Get all valid anagrams of the chosen word (excluding the word itself)
            List<String> validAnagrams = findAnagrams(chosenWord, dictionary);

            System.out.print("Enter your anagram guess: ");
            String userGuess = scanner.nextLine().trim().toLowerCase();

            if (!userGuess.matches("[a-z]+")) {
                System.out.println("Invalid input! Please enter a valid word.");
            } else if (userGuess.equals(chosenWord)) {
                System.out.println("That's the original word. Try to find a different anagram.");
            } else if (validAnagrams.contains(userGuess)) {
                System.out.println(" Correct! '" + userGuess + "' is an anagram.");
            } else {
                System.out.println(" Incorrect. That's not a valid anagram.");
                System.out.println("Some valid anagrams were: " + validAnagrams);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Thank you for playing the Anagram Solver!");
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
