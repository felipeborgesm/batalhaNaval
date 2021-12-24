package com.letscode.projeto.entities;

public class Board {

    public static void createBoard (String []numbersBoard, String[] lettersBoard) {

        String[][] board = new String[22][23];

        for (int lineNumber = 0; lineNumber < board.length; lineNumber ++){

            String[] line = board[lineNumber];

            if(lineNumber % 2 == 0){ //para linhas pares
                for (int column = 0; column < line.length; column ++){
                    if (column % 2 == 0){
                        board[lineNumber][column] = "|";
                    } else if (lineNumber == 0){
                        int numberPosition = 0;

                        for (int i = 0; i < line.length; i ++){
                            if (i % 2 != 0) {
                                board[0][i] = " " + numbersBoard[numberPosition] + " ";
                                numberPosition++;
                            }
                        }
                    } else if (column == 1){
                        int letterPosition = 0;

                        for (int position = 0; position < 22; position ++){
                            if (position % 2 == 0) {
                                board[position][1] = " " + lettersBoard[letterPosition] + " ";
                                letterPosition++;
                            }
                        }
                    } else {
                        board[lineNumber][column] = " " + " " + " ";
                    }
                }
            } else { //para linhas ímpares
                for (int position = 0; position < line.length; position ++){
                        board[lineNumber][position] = "--";
                }
            }
        }

        //mostrar o tabuleiro
        for (String[] line: board){
            for (String position: line){
                System.out.print(position);
            }
            System.out.println();
        }
    }

}
