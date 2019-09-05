/**
 * Gallows artwork from http://ascii.co.uk/art/hangman
 */
public class Gallows {

    private int wrongChoices = 0;
    private String[] steps = {
            // Empty gallows:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    " jgs_|___",
            // Head:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    " jgs_|___",
            // Neck:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |       |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    " jgs_|___",
            // Left Arm:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    " jgs_|___",
            // Right Arm:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    " jgs_|___",
            // Body:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |       |\n" +
                    "     |\n" +
                    "     |\n" +
                    " jgs_|___",
            // Left Leg:
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |       |\n" +
                    "     |      /\n" +
                    "     |\n" +
                    " jgs_|___",
            // Right Leg (complete):
            "      _______\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\|/\n" +
                    "     |       |\n" +
                    "     |      / \\\n" +
                    "     |\n" +
                    " jgs_|___"
    };

    public void print(int step) {
        System.out.println(steps[step]);
    }

    private int maximumSteps() {
        return steps.length - 1;
    }

    void addWrongChoice() {
        wrongChoices++;
    }

    String printBoard() {
        return steps[wrongChoices];
    }

    boolean isGameOver() {
        return wrongChoices == maximumSteps();
    }
}
