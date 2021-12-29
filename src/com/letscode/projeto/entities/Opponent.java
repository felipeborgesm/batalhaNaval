package com.letscode.projeto.entities;

import com.letscode.projeto.services.Controller;

import java.util.Random;

public class Opponent extends Board {

    public Opponent() {
    }

    public void placeAllShips (){
        Random random = new Random();

         for (int i = 0; i < 10; i++){
            int randomRow = random.nextInt(10);
            int rowMatrix = 2 * randomRow;

            int randomColumn = random.nextInt(10);
            int columnMatrix = (2 * randomColumn) + 3;

            boolean isPositionOccupied = Controller.isPositionOccupied(board,rowMatrix,columnMatrix);

            while (isPositionOccupied == true){
                randomRow = random.nextInt(10);
                rowMatrix = 2 * randomRow;

                randomColumn = random.nextInt(10);
                columnMatrix = (2 * randomColumn) + 3;

                isPositionOccupied = Controller.isPositionOccupied(board,rowMatrix,columnMatrix);
            }
            //coordenadas já transformadas
            Ship ship = new Ship(rowMatrix, columnMatrix);

            this.shipsList[i] = ship;

            board[rowMatrix][columnMatrix] = " N ";
         }
    }
}
