package com.letscode.projeto.entities;

import com.letscode.projeto.services.Controller;

import java.util.Random;

public class Board {

    protected Ship[] shipsList = new Ship[10];
    // tabuleiro como um atributo e não criar ele por uma função
    protected String[][] board = {
            {"|","   ","|"," 0 ","|"," 1 ","|"," 2 ","|"," 3 ","|"," 4 ","|"," 5 ","|"," 6 ","|"," 7 ","|"," 8 ","|"," 9 ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," A ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," B ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," C ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," D ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," E ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," F ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," G ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," H ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," I ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"},
            {"|"," J ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|","   ","|"},
            {"-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-","---","-"}
    };

    // construtor
    public Board() {}

    // exibir o tabuleiro no console
    public void printBoard (){
        for (String[] line: this.board){
            for (String position: line){
                System.out.print(position);
            }
            System.out.println();
        }
    }

    public String[][] getBoard() {
        return board;
    }

//    public static void createBoard (String []numbersBoard, String[] lettersBoard) {
//
//        String[][] board = new String[22][23];
//
//        for (int lineNumber = 0; lineNumber < board.length; lineNumber ++){
//
//            String[] line = board[lineNumber];
//
//            if(lineNumber % 2 == 0){ //para linhas pares
//                for (int column = 0; column < line.length; column ++){
//                    if (column % 2 == 0){
//                        board[lineNumber][column] = "|";
//                    } else if (lineNumber == 0){
//                        int numberPosition = 0;
//
//                        for (int i = 0; i < line.length; i ++){
//                            if (i % 2 != 0) {
//                                board[0][i] = " " + numbersBoard[numberPosition] + " ";
//                                numberPosition++;
//                            }
//                        }
//                    } else if (column == 1){
//                        int letterPosition = 0;
//
//                        for (int position = 0; position < 22; position ++){
//                            if (position % 2 == 0) {
//                                board[position][1] = " " + lettersBoard[letterPosition] + " ";
//                                letterPosition++;
//                            }
//                        }
//                    } else {
//                        board[lineNumber][column] = " " + " " + " ";
//                    }
//                }
//            } else { //para linhas ímpares
//                for (int position = 0; position < line.length; position ++){
//                        board[lineNumber][position] = "--";
//                }
//            }
//        }
//
//        for (String[] line: board){
//            for (String position: line){
//                System.out.print(position);
//            }
//            System.out.println();
//        }
//    }
}
