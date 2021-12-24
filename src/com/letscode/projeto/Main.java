package com.letscode.projeto;
import com.letscode.projeto.entities.Board;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lettersBoard = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] numbersBoard = {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String moviment = "";
        String numberPosition;
        String letterPosition;
        int counter = 10;
        Boolean play = true;

        //Loop principal do jogo
        do {
            System.out.println("Qual será seu moviment? ");
            moviment = scan.next();

            if (moviment.length() == 2) {
                String[] movimentoSeparado = moviment.split("");
                letterPosition = movimentoSeparado[0];
                numberPosition = movimentoSeparado[1];

                if (!Arrays.asList(lettersBoard).contains(letterPosition)) {
                    System.out.println("Letra não está contida no tabuleiro");
                } else {
                    System.out.println(letterPosition);
                    System.out.println(numberPosition);
                    Board.createBoard(numbersBoard, lettersBoard);
                }
            } else {
                System.out.println("Movimento inválido");
            }

            counter--;
            if (counter == 0) {
                play = false;
            }

        } while (play);

    }
}
