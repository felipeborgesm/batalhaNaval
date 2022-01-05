package com.letscode.projeto;
import com.letscode.projeto.entities.Opponent;
import com.letscode.projeto.entities.Player;
import com.letscode.projeto.services.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> playerMovements = new ArrayList<>();
        String movement;
        String numberPosition;
        String letterPosition;
        int playerShips = 10;
        int opponentShips = 10;
        boolean play = true;

        //Começar o jogo e colocar os navios nas posições
        System.out.println("-------------------------------------------");
        System.out.println("               Batalha Naval               ");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.print("Digite o seu nome jogador: ");
        String name = scan.next();
        Player player = new Player(name);

        player.printBoard();

        System.out.println();
        System.out.println(Player.getName() +", você possui 10 submarinos, posicione eles no tabuleiro!");
        System.out.println();

        //Arrumar essa parte
        for (int i = 0; i < 10; i++){
            System.out.print("Digite a coordenada para o submarino " + i + ": ");
            String coordinate = scan.next();

            String[] coordinateValidated = Controller.coordinateValidation(coordinate);

            boolean shipPositioned;

            while (coordinateValidated.length != 2){
                System.out.print("Insira a nova coordenada do submarino " + i + ": ");
                coordinate = scan.next();
                coordinateValidated = Controller.coordinateValidation(coordinate);
            }

            shipPositioned = player.placeShip(coordinateValidated[0], coordinateValidated[1]);

            while (!shipPositioned){
                System.out.print("Está posição já está ocupada. Por favor insira outra coordenada para o submarion " + i + ": ");
                coordinate = scan.next();
                String[] splitCoordinate = Controller.coordinateValidation(coordinate);
                shipPositioned = player.placeShip(splitCoordinate[0], splitCoordinate[1]);
            }
        }

        player.printBoard();
        System.out.println();
        System.out.println("-------- Tabuleiro Pronto --------");
        System.out.println("-------- Começando o jogo --------");
        System.out.println();

        Opponent opponent = new Opponent();
        opponent.placeAllShips();
        //MOSTRA O TABULEIRO DO OPONENTE COM OS NAVIOS POSICIONADOS
        //opponent.printBoard(opponent.getBoard());

        //LOOP PRINCIPAL DO JOGO
        do {
            System.out.println("Qual será seu movimento? ");
            movement = scan.next();

            String[] movementValidation = Controller.coordinateValidation(movement);

            if (movementValidation.length == 2) {
                String coordinate = String.join("", movementValidation);

                if (playerMovements.contains(coordinate)) {
                    System.out.println("Esse movimento já foi feito, tente algum outro.");

                } else {
                    playerMovements.add(coordinate);
                    //PRINT PARA VERIFICAR OS MOVIMENTOS DO JOGADOR
                    //System.out.println(playerMovements);

                    letterPosition = movementValidation[0];
                    numberPosition = movementValidation[1];

                    int rowMatrix = Controller.convertLetterEnterToMatrixRow(letterPosition);
                    int columnMatrix = Controller.convertNumberEnterToMatrixColumn(numberPosition);

                    Controller.Contato2(opponent.getBoard(), opponent.getControllBoard(), rowMatrix, columnMatrix);
                    boolean attack = opponent.attack(player.getBoard());

                    if (Controller.isPositionOccupied(opponent.getBoard(), rowMatrix, columnMatrix)) {
                        opponentShips--;
                    }
                    if (attack) {
                        playerShips--;
                    }

                    player.printBoard();
                    System.out.println("Número de navios restantes do jogador: " + playerShips);
                    System.out.println();
                    //MOSTRA O TABULEIRO DO OPONENTE APENAS COM OS TIROS CERTEIROS E OS TIROS NA AGUA
                    //opponent.printBoard(opponent.getControllBoard());
                    System.out.println("Número de navios restantes do oponente: " + opponentShips);
                    System.out.println();
                }
            }

            if (opponentShips == 0) {
                System.out.println("PARABÉNS " +Player.getName() +", VOCÊ GANHOU!!!");
                play = false;
            } else if (playerShips == 0) {
                System.out.println("VOCÊ PERDEU, " + Player.getName() +"!");
                play = false;
            }

        } while (play);

        System.out.println();
        System.out.println("Os tabuleiros do jogo ficaram assim: ");
        opponent.printBoard(opponent.getBoard());
        player.printBoard();
    }
}
