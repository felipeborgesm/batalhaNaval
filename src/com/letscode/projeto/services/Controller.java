package com.letscode.projeto.services;

import com.letscode.projeto.entities.Board;
import com.letscode.projeto.entities.Player;

public class Controller {

    public static boolean isPositionOccupied (String[][] board, int rowMatrix, int columnMatrix){
        boolean isPositionOccupied ;

        if (board[rowMatrix][columnMatrix] == "   " || board[rowMatrix][columnMatrix] == " - "){
            isPositionOccupied = false;
        } else {
            isPositionOccupied = true;
        }

        return isPositionOccupied;
    }

    public static void Contato (String[][] board, int rowMatrix, int columnMatrix) {
        boolean contato = false;
        contato = isPositionOccupied(board,rowMatrix,columnMatrix);

        if (contato == false ){
            board[rowMatrix][columnMatrix] = " - ";
        }
        else {
            board[rowMatrix][columnMatrix] = " * ";
        }
    }

    public static void Contato2 (String[][] board, String[][] board2, int rowMatrix, int columnMatrix) {
        boolean contato = false;
        contato = isPositionOccupied(board,rowMatrix,columnMatrix);

        if (contato == false ){
            board[rowMatrix][columnMatrix] = " - ";
            board2[rowMatrix][columnMatrix] = " - ";
        } else {
            board[rowMatrix][columnMatrix] = " * ";
            board2[rowMatrix][columnMatrix] = " * ";
        }
    }
}
