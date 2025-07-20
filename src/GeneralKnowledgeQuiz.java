import java.util.*;

public class GeneralKnowledgeQuiz {
    private final List<String> questions = new ArrayList<>();
    private final List<String[]> options = new ArrayList<>();
    private final List<String> answers = new ArrayList<>();

    public GeneralKnowledgeQuiz() {
        questions.add("What is the capital of France?");
        options.add(new String[]{"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"});
        answers.add("C");

        questions.add("Which planet is known as the Red Planet?");
        options.add(new String[]{"A. Earth", "B. Venus", "C. Mars", "D. Jupiter"});
        answers.add("C");

        questions.add("Who painted the Mona Lisa?");
        options.add(new String[]{"A. Vincent Van Gogh", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Michelangelo"});
        answers.add("C");

        questions.add("What is the largest mammal?");
        options.add(new String[]{"A. Elephant", "B. Blue whale", "C. Giraffe", "D. Orca"});
        answers.add("B");

        questions.add("What is the currency of Japan?");
        options.add(new String[]{"A. Yen", "B. Won", "C. Peso", "D. Dollar"});
        answers.add("A");

        // 🔁 Add more questions below in the same format...
    }

    public static void play(Scanner scanner) {
        GeneralKnowledgeQuiz quiz = new GeneralKnowledgeQuiz();
        Random rand = new Random();

        while (!quiz.questions.isEmpty()) {
            int index = rand.nextInt(quiz.questions.size());

            System.out.println("\n------------------ GENERAL KNOWLEDGE QUIZ ------------------");
            System.out.println("QUESTION: " + quiz.questions.get(index));
            for (String option : quiz.options.get(index)) {
                System.out.println(option);
            }

            System.out.print("\nYour answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().trim().toUpperCase();

            if (userAnswer.equals(quiz.answers.get(index))) {
                System.out.println("\n🎉 CORRECT!");
            } else {
                System.out.println("\n❌ WRONG! The correct answer is: " + quiz.answers.get(index));
            }

            quiz.questions.remove(index);
            quiz.options.remove(index);
            quiz.answers.remove(index);

            if (quiz.questions.isEmpty()) {
                System.out.println("\n✅ You've completed the quiz!");
                break;
            }

            System.out.print("\nDo you want to continue? (Y/N): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.println("\nThank you for playing!");
    }
}
