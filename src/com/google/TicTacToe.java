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
        int opponent = 0;
        int fieldSize = 0;

        System.out.print("Enter the first player's name: ");
        String firstName = scanner.nextLine();
        String secondName = null;


        do {
            try {
                isCorrect = true;
                System.out.print("Enter the second player's name: ");
                secondName = scanner.nextLine();
                if (firstName.equals(secondName)) {
                    isCorrect = false;
                    continue;
                }
                System.out.println("Would you like to play with a real player or with a machine?");
                System.out.println("1 - alive");
                System.out.println("2 - machine");

                opponent = scanner.nextInt();

                System.out.print("Enter the field's size: ");
                fieldSize = scanner.nextInt();

                if (opponent < 1 || opponent > 2 || fieldSize < 3) {
                    isCorrect = false;
                }
            } catch (InputMismatchException exception) {
                isCorrect = false;
                scanner.next();
            }
        } while (!isCorrect);

        if (opponent == 1) {
            secondPlayer = new Person(secondName, Figure.ZERO);
        } else {
            secondPlayer = new Machine(secondName, Figure.ZERO);
        }

        Player firstPlayer = new Person(firstName, Figure.CROSS);

        Game game = new Game(firstPlayer, secondPlayer, fieldSize);
        game.playing();
    }
}
