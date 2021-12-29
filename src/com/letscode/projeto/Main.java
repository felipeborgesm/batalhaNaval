package com.letscode.projeto;
import com.letscode.projeto.entities.Board;
import com.letscode.projeto.entities.Opponent;
import com.letscode.projeto.entities.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lettersBoard = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] numbersBoard = {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String movement = "";
        String numberPosition;
        String letterPosition;
        int counter = 10;
        Boolean play = true;

        //Começar o jogo e colocar os navios nas posições
        System.out.println("-------------------------------------------");
        System.out.println("               Batalha Naval               ");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.print("Digite o seu nome do jogador: ");
        String name = scan.next();
        Player player = new Player(name);

        player.printBoard();

        System.out.println();
        System.out.println("Posicione seus submarinos! Você possui 10");
        System.out.println();

        //Arrumar essa parte
        for (int i = 0; i < 10; i++){
            System.out.print("Digite a coordenada para o submarino " + i + ": ");
            String coordinate = scan.next();

            boolean shipPositioned = false;

            // verificação muito parecida com a do loop principal
            if (coordinate.length() == 2) {
                String[] splitCoordinate = coordinate.split("");
                letterPosition = splitCoordinate[0];
                numberPosition = splitCoordinate[1];

                if (!Arrays.asList(lettersBoard).contains(letterPosition)) {
                    System.out.println("Letra não está contida no tabuleiro");
                    System.out.print("Digite a letra novamente: ");
                    letterPosition = scan.next();
                }
            } else {
                System.out.println("Movimento inválido");
                System.out.print("Digite a coordenada para o submarino " + i + " novamente: ");
                coordinate = scan.next();
                String[] splitCoordinate = coordinate.split("");
                letterPosition = splitCoordinate[0];
                numberPosition = splitCoordinate[1];
            }
            shipPositioned = player.placeShip(letterPosition, numberPosition, i);


            while (shipPositioned == false){
                System.out.print("Está posição já está ocupada. Por favor insira outra coordenada: ");
                coordinate = scan.next();
                String[] splitCoordinate = coordinate.split("");
                letterPosition = splitCoordinate[0];
                numberPosition = splitCoordinate[1];

                shipPositioned = player.placeShip(letterPosition, numberPosition, i);
            }
        }

        player.printBoard();

        System.out.println();
        System.out.println("-------- Tabuleiro Pronto --------");
        System.out.println("-------- Começando o jogo --------");
        System.out.println();
        //Loop principal do jogo

        Opponent opponent = new Opponent();
        opponent.placeAllShips();

        do {
            System.out.println("Qual será seu movimento? ");
            movement = scan.next();

            if (movement.length() == 2) {
                String[] movimentoSeparado = movement.split("");
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
