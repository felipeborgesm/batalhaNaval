package com.letscode.projeto.entities;
public class Board {

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
}
