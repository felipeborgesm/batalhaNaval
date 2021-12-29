package com.letscode.projeto.services;

import com.letscode.projeto.entities.Board;
import com.letscode.projeto.entities.Player;

public class Controller {

    public static boolean isPositionOccupied (String[][] board, int rowMatrix, int columnMatrix){
        boolean isPositionOccupied = true;

        if (board[rowMatrix][columnMatrix] == "   "){isPositionOccupied = false;}

        return isPositionOccupied;
    }
}
