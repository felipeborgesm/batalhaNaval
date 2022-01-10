package com.letscode.projeto.services;

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
}
