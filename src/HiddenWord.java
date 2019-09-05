import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class HiddenWord {
    private static String secretWord;

    HiddenWord() {
        secretWord = getRandomWord().toUpperCase();
    }

    private String getRandomWord() {
        ArrayList<String> words = new ArrayList<String>();
        try {
            File file = new File("./words");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    words.add(scanner.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words.get(new Random().nextInt(words.size()));
    }

    boolean contains(@NotNull String pickedLetter) {
        return secretWord.contains(pickedLetter.toUpperCase());
    }

    String printBoard(AvailableChoices AvailableChoices) {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (AvailableChoices.notAvailable(secretWord.charAt(i) + "")) {
                board.append(secretWord.charAt(i)).append(" ");
            } else {
                board.append("_ ");
            }
        }
        return board.toString();
    }

    boolean isGameOver(AvailableChoices AvailableChoices) {
        int solvedLetters = 0;
        for (int i = 0; i < secretWord.length(); i++) {
            if (AvailableChoices.notAvailable(secretWord.charAt(i) + "")) {
                solvedLetters++;
            }
        }
        return solvedLetters == secretWord.length();
    }

    String getSecretWord() {
        return secretWord;
    }
}
