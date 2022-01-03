package com.letscode.projeto.entities;

import com.letscode.projeto.services.Controller;

public class Player extends Board{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void printBoard() {
        System.out.println("---------------------------------------------");
        System.out.println("                   "+ this.name +"                   ");
        System.out.println("---------------------------------------------");
        super.printBoard();
    }

    public boolean placeShip (String letterPosition, String numberPosition, int numOfShip){

        boolean shipPositioned;

        //msm do main
        String[] lettersBoard = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        int i = 0;
        int rowMatrix = 0;

        while (i < lettersBoard.length){
            if (letterPosition.equalsIgnoreCase(lettersBoard[i])){
                rowMatrix = (2 * i) + 2;
                break;
            }
            i ++;
        }

        //Equanção de conversão: índiceDaMatriz = (2 * posiçãoDesejada) + 3
        int columnMatrix = (2 * Integer.parseInt(numberPosition) + 3);

        boolean isPositionOccupied = Controller.isPositionOccupied(board,rowMatrix,columnMatrix);

        //verificando se a posição indicada está ocupada
        if (isPositionOccupied == true){
            shipPositioned = false;
        } else {
        //posição com da matriz
        Ship ship = new Ship(rowMatrix, columnMatrix);

        //colocando o barco dentro da variável
        this.shipsList[numOfShip] = ship;

        //alterar o tabuleiro do jogador
        this.board[rowMatrix][columnMatrix] = " N ";

        shipPositioned = true;
        }

        return shipPositioned;
    }

    public String getName() {
        return name;
    }

}