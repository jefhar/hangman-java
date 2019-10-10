package us.jeffharris.hangman;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

class AvailableChoices {
  private HashSet<Character> availableChoices;

  @Contract(pure = true)
  AvailableChoices() {
    availableChoices = new HashSet<>();
  }

  boolean notAvailable(@NotNull String pickedLetter) {
    char letter = pickedLetter.charAt(0);
    return availableChoices.contains(letter);
  }

  private void add(@NotNull String pickedLetter) {
    availableChoices.add(pickedLetter.charAt(0));
  }

  void remove(@NotNull String pickedLetter) {
    add(pickedLetter);
  }

  String printBoard() {
    int A = 'A';
    int Z = 'Z';
    StringBuilder word = new StringBuilder();
    for (int i = A; i <= Z; i++) {
      if (notAvailable(Character.toString((char) i))) {
        word.append("_ ");
      } else {
        word.append((char) i).append(" ");
      }
    }
    return word.toString();
  }
}
