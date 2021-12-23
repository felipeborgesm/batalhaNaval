package com.letscode.projeto;


import com.letscode.projeto.entities.Board;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
	    String[] letrasTabuleiro = {"A","B","C","D","E","F","G","H","I","J"};
        Integer[] numerosTabuleiro = {0,1,2,3,4,5,6,7,8,9};
        String movimento = "";
        int posicaoNumero;
        String posicaoLetra;
        Boolean jogar = true;

        System.out.println("Qual será seu movimento? ");
        movimento = leitor.next();
        String[] movimentoSeparado = movimento.split("");

        posicaoLetra = movimentoSeparado[0];
        posicaoNumero = Integer.parseInt(movimentoSeparado[1]);
        System.out.println(posicaoLetra);
        System.out.println(posicaoNumero);


        if (Arrays.asList(letrasTabuleiro).contains(posicaoLetra)) {
            System.out.println("funcionou");
        }
//        do {
//
//        } while (jogar == true);

        Board.createBoard();
    }

    }
