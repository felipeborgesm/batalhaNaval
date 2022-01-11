package com.letscode.projeto.entities;
import com.letscode.projeto.services.Controller;
import static com.letscode.projeto.services.Controller.*;

public class Opponent extends Board {

    public Opponent() {}

    public void printBoard(String[][] board) {
        System.out.println("---------------------------------------------");
        System.out.println("                   OPONENTE                   ");
        System.out.println("---------------------------------------------");
        for (String[] line: board){
            for (String position: line){
                System.out.print(position);
            }
            System.out.println();
        }
    }

    public void placeAllShips () {
         for (int i = 0; i < 10; i++){
             int rowMatrix = sortNumberRow();
             int columnMatrix = sortNumberColumn();
             boolean isPositionOccupied = isPositionOccupied(board,rowMatrix,columnMatrix);

             while (isPositionOccupied){
                 rowMatrix = sortNumberRow();

                 columnMatrix = sortNumberColumn();

                 isPositionOccupied = isPositionOccupied(board,rowMatrix,columnMatrix);
            }
             //coordenadas já transformadas
             board[rowMatrix][columnMatrix] = " N ";
         }
    }

    public boolean attack (String[][] board) {
        boolean attack = false;
        boolean loop = true;

//      ESSE LOOP FAZ COM O QUE MOVIMENTO NAO SEJA REPETIDO PELA MAQUINA
        do {
            int numberRow = sortNumberRow();
            String rowMatrix1 = Integer.toString(numberRow);

            int numberColumn = sortNumberColumn();
            String columnMatrix1 = Integer.toString(numberColumn);

            String coordinate = rowMatrix1 + columnMatrix1;

            if (!this.movementsList.contains(coordinate)) {
                this.movementsList.add(coordinate);
                Controller.attack(board, numberRow, numberColumn);
                attack = isPositionOccupied(board, numberRow, numberColumn);
                loop = false;
            }

        } while (loop);

        return attack;
    }
}
