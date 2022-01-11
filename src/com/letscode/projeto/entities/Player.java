package com.letscode.projeto.entities;
import com.letscode.projeto.services.Controller;

import java.util.Scanner;

public class Player extends Board{

    private static String name;

    public Player(String name) {
        Player.name = name;
    }

    @Override
    public void printBoard() {
        System.out.println("---------------------------------------------");
        System.out.println("                   "+ name +"                   ");
        System.out.println("---------------------------------------------");
        super.printBoard();
    }

    public boolean placeShip(String letterPosition, String numberPosition){

        boolean shipPositioned;

        int rowMatrix = Controller.convertLetterEnterToMatrixRow(letterPosition);
        int columnMatrix = Controller.convertNumberEnterToMatrixColumn(numberPosition);

        boolean isPositionOccupied = Controller.isPositionOccupied(board,rowMatrix,columnMatrix);

        //verificando se a posição indicada está ocupada
        if (isPositionOccupied){
            shipPositioned = false;
        } else {
            //alterar o tabuleiro do jogador
            this.board[rowMatrix][columnMatrix] = " N ";

            shipPositioned = true;
        }

        return shipPositioned;
    }

    public void setAllShipsPositions (){
        System.out.println();
        System.out.println( name +", você possui 10 submarinos, posicione eles no tabuleiro!");
        System.out.println();

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            System.out.print("Digite a coordenada para o submarino " + i + ": ");
            String coordinate = scan.next();

            String[] coordinateValidated = Controller.coordinateValidation(coordinate);

            while (coordinateValidated.length != 2){
                System.out.print("Insira a nova coordenada do submarino " + i + ": ");
                coordinate = scan.next();
                coordinateValidated = Controller.coordinateValidation(coordinate);
            }

            boolean shipPositioned = placeShip(coordinateValidated[0], coordinateValidated[1]);

            while (!shipPositioned){
                System.out.print("Está posição já está ocupada. Por favor insira outra coordenada para o submarion " + i + ": ");
                coordinate = scan.next();
                String[] splitCoordinate = Controller.coordinateValidation(coordinate);
                shipPositioned = placeShip(splitCoordinate[0], splitCoordinate[1]);
            }
        }
    }

    public static String getName() {
        return name;
    }

}