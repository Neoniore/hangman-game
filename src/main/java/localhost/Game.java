package localhost;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public void introGame() {
        System.out.println("Игра Виселица - угадай слово.");
        Scanner scanner = new Scanner(System.in);
        boolean wantPlay = true;
        do {
            System.out.println("S - Старт новой игры;\nE - выход");
            switch (scanner.nextLine().toLowerCase()) {
                case ("s"): {
                    startGame();
                    break;
                }
                case ("e"): {
                    wantPlay = false;
                    break;
                }
                default:
                    System.out.println("-----\nВведите правильный символ\n-----\n");
            }
        } while (wantPlay);
    }

    private void startGame() {
        String selectedWord = choiceOfWord();
        StringBuilder wordMask = createWordMask(selectedWord);
        Scanner scanner = new Scanner(System.in);
        int err = 0;
        char inputSumbol;
        List<String> usedWords = new ArrayList<>();

        System.out.println(selectedWord);

        do {
            if (!usedWords.isEmpty()) {
                System.out.printf("Уже использованные буквы: %s\n", usedWords);
            }
            System.out.println(wordMask);
            System.out.println("Введите букву:");

            inputSumbol = scanner.next().charAt(0);

            if (selectedWord.toLowerCase().contains(String.valueOf(inputSumbol).toLowerCase())) {
                if (usedWords.contains(String.valueOf(inputSumbol).toUpperCase())) {
                    continue;
                }
                System.out.printf("Буква %s есть в загаданном слове!\n", inputSumbol);
                wordMask = changeWordMask(selectedWord, wordMask, inputSumbol);
            } else {
                System.out.printf("Буквы %s нет в загаданном слове!\n", inputSumbol);
                if (usedWords.contains(String.valueOf(inputSumbol).toUpperCase())) {
                    continue;
                } else {
                    err++;
                }
            }
            usedWords.add(String.valueOf(inputSumbol).toUpperCase());

            if (selectedWord.equalsIgnoreCase(String.valueOf(wordMask))) {
                System.out.println("\n-----\nВы победили!\n-----\n");
                System.out.println(wordMask);
                break;
            }

            displayingTheStateOfTheGallows(err);
        } while (err < 5);

        if (err == 5) {
            System.out.println("\n-----\nВы проиграли!\n-----\n");
        }

    }

    private String choiceOfWord() {
        return Dictionary.getNoun();
    }

    private StringBuilder createWordMask(String word) {
        StringBuilder wordMask = new StringBuilder();
        wordMask.append("*".repeat(word.length()));
        return wordMask;
    }

    private StringBuilder changeWordMask(String word, StringBuilder wordMask, char sumbol) {
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(sumbol))) {
                wordMask.setCharAt(i, word.charAt(i));
            }
        }
        return wordMask;
    }

    private void displayingTheStateOfTheGallows(int err) {
        System.out.printf("Ошибок допущено: %d\nОсталось ошибок: %d\n", err, 5-err);
            switch (err) {
                case (1): {
                    System.out.println("____________\n|\n|\n|\n|\n|\n|\n|\n|\n|________________|\n");
                    break;
                }
                case (2): {
                    System.out.println("____________\n| /\n|/\n|\n|\n|\n|\n|\n|\n|\n|________________|");
                    break;
                }
                case (3): {
                    System.out.println("____________\n| /        |\n|/         |\n|\n|\n|\n|\n|\n|\n|\n|________________|");
                    break;
                }
                case (4): {
                    System.out.println("____________\n| /        |\n|/         |\n|        (o_o)\n|          |\n|         /|\\\n|          |\n|         / \\\n|\n|\n|________________|");
                    break;
                }
                case (5): {
                    System.out.println("____________\n| /        |\n|/         |\n|        (x_x)\n|          |\n|         /|\\\n|          |\n|         / \\\n|\n|\n|________________|");
                    break;
                }
            }
        }
}
