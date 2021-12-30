package com.letscode.projeto.entities;

import com.letscode.projeto.services.Controller;

import java.util.Random;

public class Opponent extends Board {

    public String[][] board2 ={
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

    public Opponent() {
    }

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

    public void placeAllShips (){
        Random random = new Random();

         for (int i = 0; i < 10; i++){
            int randomRow = random.nextInt(10);
            int rowMatrix = (2 * randomRow) + 2;

            int randomColumn = random.nextInt(10);
            int columnMatrix = (2 * randomColumn) + 3;

            boolean isPositionOccupied = Controller.isPositionOccupied(board,rowMatrix,columnMatrix);

            while (isPositionOccupied == true){
                randomRow = random.nextInt(10);
                rowMatrix = (2 * randomRow) + 2;

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

    public boolean attack (String[][] board) {
        boolean attack = false;
        Random random = new Random();
        int randomRow = random.nextInt(10);
        int rowMatrix = (2 * randomRow) + 2;

        int randomColumn = random.nextInt(10);
        int columnMatrix = (2 * randomColumn) + 3;

        Controller.Contato(board, rowMatrix, columnMatrix);
        attack = Controller.isPositionOccupied(board, rowMatrix, columnMatrix);

        return attack;
    }
}
