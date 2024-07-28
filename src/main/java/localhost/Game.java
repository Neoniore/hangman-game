package localhost;

import java.util.Scanner;

public class Game {
    public static int id;

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

    }
}
