package com.google;

import com.google.game.GameField;
import com.google.game.Figure;
import com.google.game.Game;
import com.google.player.Machine;
import com.google.player.Person;
import com.google.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        Player secondPlayer;
        int yourOpponent = 0;
        GameField field;
        System.out.print("Enter the first player's name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the second player's name: ");
        String secondName = scanner.nextLine();

        Player firstPlayer = new Person(firstName, Figure.CROSS);

        do {
            isCorrect = true;
            System.out.println("Would you like to play with a real player or with a machine?");
            System.out.println("1 - alive");
            System.out.println("2 - machine");

            try {
                yourOpponent = scanner.nextInt();
            } catch (InputMismatchException exception) {
                isCorrect = false;
                scanner.next();
            }
        } while (!isCorrect);

        secondPlayer = switch (yourOpponent) {
            case 1 -> new Person(secondName, Figure.ZERO);
            case 2 -> new Machine(secondName, Figure.ZERO);
            default -> {
                isCorrect = false;
                yield new Person(secondName, Figure.CROSS);
            }
        };
        Game game = new Game(firstPlayer, secondPlayer, 3);
        game.playing();
    }
}
