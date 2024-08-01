package localhost;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static int id;

    public Game() {
        id++;
    }

    private String choiceOfWord() {
        return Dictionary.getNoun();
    }

    public void introGame() {
        Scanner scanner = new Scanner(System.in);
        boolean wantPlay = true;
        while (true) {
            System.out.println("Игра Виселица - угадай слово.\nS - Старт новой игры;\nE - выход");
            switch (scanner.nextLine()) {
                case ("S"):
                case ("s"):{
                    startGame();
                    break;
                }
                case ("E"):
                case ("e"):{
                    wantPlay = false;
                    break;
                }
                default:
                    System.out.println("-----\nВведите правильный символ\n-----\n");
            }
            if (!wantPlay) {break;}
        }
    }

    private void startGame() {
        String selectedWord = choiceOfWord();
        StringBuilder wordMask = createWordMask(selectedWord);
        Scanner scanner = new Scanner(System.in);
        int err = 0;
        char inputSumbol = '0';
        List<String> usedWords= new ArrayList<>();

        System.out.println(selectedWord);

        do {
            System.out.println(wordMask);
            System.out.println("Введите букву:");
            inputSumbol = scanner.next().charAt(0);
            System.out.println(inputSumbol);
            if (selectedWord.contains(String.valueOf(inputSumbol))) {
                System.out.printf("Буква %s есть в загаданном слове!\n", inputSumbol);
                usedWords.add(String.valueOf(inputSumbol));
                wordMask = changeWordMask(selectedWord, wordMask, inputSumbol);
            } else {
                System.out.printf("Буквы %s нет в загаданном слове!\n", inputSumbol);
                err++;
                usedWords.add(String.valueOf(inputSumbol));
            }
            if (selectedWord.equals(wordMask)) {
                System.out.println("Вы победили!");
                break;
            }
            System.out.printf("Уже использованные буквы: %s\n", usedWords);
        }while(err <=5 );
    }

    private StringBuilder createWordMask(String word) {
        StringBuilder wordMask = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordMask.append("*");
        }
        return wordMask;
    }

    private StringBuilder changeWordMask(String word, StringBuilder Wordmask, char sumbol) {
        StringBuilder wordMask = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == sumbol) {
                wordMask.setCharAt(i,sumbol);
            }
        }
        return wordMask;
    }
}
