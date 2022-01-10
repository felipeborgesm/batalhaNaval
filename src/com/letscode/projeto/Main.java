package com.letscode.projeto;
import com.letscode.projeto.entities.Opponent;
import com.letscode.projeto.entities.Player;
import com.letscode.projeto.services.Controller;
import com.letscode.projeto.services.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Começando o jogo
        boolean isPlaying = Menu.startsGame();

        if (!isPlaying){
            isPlaying = Menu.endingGame();
        }

        while (isPlaying) {
            //Criando o jogador e posicionando os navios do jogador
            Player player = Menu.createPlayer();
            player.setAllShipsPositions();


            player.printBoard();
            System.out.println();
            System.out.println("---------------------------------- Tabuleiro Pronto ----------------------------------");
            System.out.println("---------------------------------- Começando o jogo ----------------------------------");
            System.out.println();

            //Criação do Oponente
            Opponent opponent = new Opponent();
            opponent.placeAllShips();

            //LOOP PRINCIPAL DO JOGO
            String movement;
            String numberPosition;
            String letterPosition;

            Scanner scan = new Scanner(System.in);
            do {
                System.out.println("Qual será seu movimento? ");
                movement = scan.next();

                String[] movementValidation = Controller.coordinateValidation(movement);

                if (movementValidation.length == 2) {
                    String coordinate = String.join("", movementValidation);

                    if (player.getMovementsList().contains(coordinate)) {
                        System.out.println("Esse movimento já foi feito, tente algum outro.");
                    } else {
                        player.getMovementsList().add(coordinate);
                        //PRINT PARA VERIFICAR OS MOVIMENTOS DO JOGADOR
                        //System.out.println(player.getMovementsList());

                        letterPosition = movementValidation[0];
                        numberPosition = movementValidation[1];

                        int rowMatrix = Controller.convertLetterEnterToMatrixRow(letterPosition);
                        int columnMatrix = Controller.convertNumberEnterToMatrixColumn(numberPosition);

                        Controller.attack(opponent.getBoard(), rowMatrix, columnMatrix);

                        if (Controller.isPositionOccupied(opponent.getBoard(), rowMatrix, columnMatrix)) {
                            System.out.println("Muito bem! Você acertou um navio adversáio!");
                            opponent.updateRemainingShips();
                        }

                        boolean opponentAttack = opponent.attack(player.getBoard());

                        if (opponentAttack) {
                            System.out.println("Cuidado! O oponente acertou um dos seus navios");
                            player.updateRemainingShips();
                        }

                        player.printBoard();
                        System.out.println("Número de navios restantes do jogador: " + player.getRemainingShips());
                        System.out.println();
                        System.out.println("Número de navios restantes do oponente: " + opponent.getRemainingShips());
                        System.out.println();
                    }
                }

                if (opponent.getRemainingShips() == 0) {
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                                PARABÉNS " + Player.getName() + ", VOCÊ GANHOU!!!");
                    isPlaying = false;
                } else if (player.getRemainingShips() == 0) {
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                                VOCÊ PERDEU, " + Player.getName() + "!");
                    isPlaying = false;
                }

            } while (isPlaying);

            System.out.println();
            System.out.println("Os tabuleiros do jogo ficaram assim: ");
            opponent.printBoard(opponent.getBoard());
            player.printBoard();

            isPlaying = Menu.keepPlaying();
        }

        System.out.println();
        System.out.println("=================================== Obrigada por jogar ==================================");
    }
}
