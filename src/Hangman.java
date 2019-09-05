import java.util.Scanner;

public class Hangman {
    private static AvailableChoices AvailableChoices;
    private static Gallows Gallows;
    private static HiddenWord HiddenWord;
    private static Scanner input;
    private static int turn;

    public static void main(String[] args) {
        boolean gameOver = false;
        setupGame();
        printBoard();
        while (!gameOver) {
            String letter = pickLetter();
            processChoice(letter);
            turn++;
            printBoard();
            gameOver = gameOver();
        }
        endGame();
    }

    private static void setupGame() {
        AvailableChoices = new AvailableChoices();
        Gallows = new Gallows();
        HiddenWord = new HiddenWord();
        turn = 0;
        input = new Scanner(System.in);
    }

    private static void printBoard() {
        System.out.println("\n========================================");
        System.out.println("Turn: " + (turn + 1));
        System.out.print("Available Letters: ");
        System.out.println(AvailableChoices.printBoard());
        System.out.println(Gallows.printBoard());
        System.out.println(HiddenWord.printBoard(AvailableChoices));
    }

    private static String pickLetter() {
        System.out.print("Enter a letter: ");
        String letter = input.next();
        return letter.substring(0, 1).toUpperCase();
    }

    private static void processChoice(String letter) {
        if (AvailableChoices.notAvailable(letter)) {
            return;
        }
        if (!HiddenWord.contains(letter)) {
            Gallows.addWrongChoice();
        }
        AvailableChoices.remove(letter);
    }

    private static boolean gameOver() {
        return Gallows.isGameOver() || HiddenWord.isGameOver(AvailableChoices);
    }

    private static void endGame() {
        if (Gallows.isGameOver()) {
            System.out.println("You Lose! The secret word was '" + HiddenWord.getSecretWord() + "'. Please try again soon.");
        } else {
            System.out.println("You Win!");
        }
    }
}
