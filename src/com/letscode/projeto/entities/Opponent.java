package com.letscode.projeto.entities;

import java.util.ArrayList;
import java.util.Random;

import static com.letscode.projeto.services.Controller.Contato;
import static com.letscode.projeto.services.Controller.isPositionOccupied;

public class Opponent extends Board {
    ArrayList<String> opponentMovements = new ArrayList<>();
    public String[][] controllBoard ={
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

            boolean isPositionOccupied = isPositionOccupied(board,rowMatrix,columnMatrix);

            while (isPositionOccupied){
                randomRow = random.nextInt(10);
                rowMatrix = (2 * randomRow) + 2;

                randomColumn = random.nextInt(10);
                columnMatrix = (2 * randomColumn) + 3;

                isPositionOccupied = isPositionOccupied(board,rowMatrix,columnMatrix);
            }
            //coordenadas já transformadas
            board[rowMatrix][columnMatrix] = " N ";
         }
    }

    public boolean attack (String[][] board) {
        boolean attack = false;
        Random random = new Random();
        boolean loop = true;

//      ESSE LOOP FAZ COM O QUE MOVIMENTO NAO SEJA REPETIDO PELA MAQUINA
        do {
            int randomRow = random.nextInt(10);
            int rowMatrix = (2 * randomRow) + 2;
            String rowMatrix1 = Integer.toString(rowMatrix);

            int randomColumn = random.nextInt(10);
            int columnMatrix = (2 * randomColumn) + 3;
            String columnMatrix1 = Integer.toString(columnMatrix);

            String coordinate = rowMatrix1 + columnMatrix1;

            if (!opponentMovements.contains(coordinate)) {
                opponentMovements.add(coordinate);
                Contato(board, rowMatrix, columnMatrix);
                attack = isPositionOccupied(board, rowMatrix, columnMatrix);
                loop = false;
            }

        } while (loop);
        //PRINT PARA VERIFICAR OS MOVIMENTOS DA MAQUINA
        //System.out.println(opponentMovements);
        return attack;
    }

    public String[][] getControllBoard() {
        return controllBoard;
    }
}
