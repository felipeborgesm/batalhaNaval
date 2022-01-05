package com.letscode.projeto.entities;

import com.letscode.projeto.services.Controller;

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

    public static String getName() {
        return name;
    }

}