package com.letscode.projeto;
import com.letscode.projeto.entities.Opponent;
import com.letscode.projeto.entities.Player;
import com.letscode.projeto.services.Menu;

public class Main {

    public static void main(String[] args) {
        //Começando o jogo
        boolean isPlaying = Menu.startsGame();

        if (!isPlaying){
            isPlaying = Menu.endingGame();
        }

        //LOOP PRINCIPAL DO JOGO
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
            // IMPORTANTE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            opponent.printBoard();

            Menu.runGame(player, opponent);

            System.out.println();
            System.out.println("Os tabuleiros do jogo ficaram assim: ");
            opponent.printBoard();
            player.printBoard();

            isPlaying = Menu.keepPlaying();
        }

        System.out.println();
        System.out.println("=================================== Obrigada por jogar ==================================");
    }
}
