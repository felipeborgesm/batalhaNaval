package com.letscode.projeto;
import com.letscode.projeto.entities.Board;
import com.letscode.projeto.entities.Opponent;
import com.letscode.projeto.entities.Player;
import com.letscode.projeto.services.Controller;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lettersBoard = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] numbersBoard = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String movement = "";
        String numberPosition;
        String letterPosition;
        int playerShips = 10;
        int opponentShips = 10;
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


        Opponent opponent = new Opponent();
        opponent.placeAllShips();
        //mostra o tabuleiro do oponente com os navios posicionados
        //opponent.printBoard(opponent.getBoard());

        //Loop principal do jogo
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
                    int i = 0;
                    int rowMatrix = 0;
                    while (i < lettersBoard.length){
                        if (letterPosition.equalsIgnoreCase(lettersBoard[i])){
                            rowMatrix = (2 * i) + 2;
                            break;
                        }
                        i ++;
                    }
                    //Equanção de conversão: índiceDaMatriz = (2 * posiçãoDesejada) + 3
                    int columnMatrix = (2 * Integer.parseInt(numberPosition) + 3);

                    Controller.Contato2(opponent.getBoard(), opponent.board2, rowMatrix, columnMatrix);
                    boolean attack = opponent.attack(player.getBoard());

                    if (Controller.isPositionOccupied(opponent.getBoard(), rowMatrix, columnMatrix) == true) {
                        opponentShips--;
                    }
                    if (attack == true) {
                        playerShips--;
                    }

                    player.printBoard();
                    System.out.println("Número de navios restantes do jogador: " +playerShips);
                    System.out.println();
                    //mostra o tabuleiro do oponente apenas com os tiros na agua e os tiros acertados
                    //opponent.printBoard(opponent.board2);
                    System.out.println("Número de navios restantes do oponente: " +opponentShips);
                    System.out.println();

                }
            } else {
                System.out.println("Movimento inválido");
            }

            if (opponentShips == 0) {
                System.out.println("Parabéns, você ganhou");
                play = false;
            } else if (playerShips == 0) {
                System.out.println("Você perdeu");
                play = false;
            }

        } while (play);

        System.out.println();
        System.out.println("Esses são os tabuleiros: ");
        opponent.printBoard(opponent.getBoard());
        player.printBoard();
    }
}
