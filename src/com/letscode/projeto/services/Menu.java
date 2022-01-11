package com.letscode.projeto.services;
import com.letscode.projeto.entities.Opponent;
import com.letscode.projeto.entities.Player;
import java.util.Scanner;

public class Menu {

    public static boolean startsGame (){
        System.out.println("=========================================================================================");
        System.out.println("                                  Bem vindo ao jogo Batalha Naval");
        System.out.println("=========================================================================================");
        System.out.println();
        System.out.print("Para começar a jogar digite S. Caso não queira digite N : ");

        Scanner scanner = new Scanner(System.in);

        String play = scanner.next();

        return play.equalsIgnoreCase("S");
    }

    public static Player createPlayer (){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("---------------------------- Criando o jogador -------------------------------------------");
        System.out.println();
        System.out.print("Digite o nome do jogador: ");

        String name = scanner.next();
        Player player = new Player(name);

        player.printBoard();

        return  player;
    }

    public static boolean keepPlaying (){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("---------------------------- Rodada Finalizada ------------------------------------------");
        System.out.print("Se quiser começar um novo jogo digite S. Caso contrário digite N: ");

        String keepPlaying = scanner.next();

        return keepPlaying.equalsIgnoreCase("s");
    }

    public static boolean endingGame (){
        System.out.println("Certeza que deseja sair?");
        System.out.print("Se desejar sair digites S . Caso contrário digite N : ");

        Scanner scanner = new Scanner(System.in);

        String play = scanner.next();

        if (play.equalsIgnoreCase("S")){
            System.exit(1);
        }

        return true;
    }

    public static void runGame (Player player, Opponent opponent) {
        String movement;
        String numberPosition ;
        String letterPosition;
        boolean loop =  true;
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
                System.out.println("                            PARABÉNS " + Player.getName() + ", VOCÊ GANHOU!!!");
                loop = false;
            } else if (player.getRemainingShips() == 0) {
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("                            VOCÊ PERDEU, " + Player.getName() + "!");
                loop = false;
            }

        } while (loop);
    }
}

