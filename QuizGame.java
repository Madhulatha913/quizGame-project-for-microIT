package game;
import java.util.Scanner;

public class QuizGame {

    static class Question {
        String questionText;
        String[] options;
        char correctAnswer;

        Question(String questionText, String[] options, char correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        boolean askQuestion(Scanner scanner) {
            System.out.println("\n" + questionText);
            char optionChar = 'A';
            for (String option : options) {
                System.out.println(optionChar + ". " + option);
                optionChar++;
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char answer = scanner.next().toUpperCase().charAt(0);
            return answer == correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = {
            new Question("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 'C'),
            new Question("Which language is used for Android development?",
                new String[]{"Python", "Kotlin", "Swift", "Ruby"}, 'B'),
            new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 'C'),
            new Question("What is the result of 3 + 4 * 2?",
                new String[]{"14", "11", "10", "7"}, 'B')
        };

        int score = 0;

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("-------------------------");

        for (Question q : questions) {
            if (q.askQuestion(scanner)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\nQuiz Over! You scored " + score + " out of " + questions.length);
        if (score >= questions.length * 0.75) {
            System.out.println("🎉 Excellent! You passed the quiz.");
        } else {
            System.out.println("👍 Good try! Keep practicing.");
        }

        scanner.close();
    }
}
