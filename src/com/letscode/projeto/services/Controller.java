package com.letscode.projeto.services;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Controller {

    //verifica se a posicao indicada pelo jogador esta vazia ou nao
    public static boolean isPositionOccupied (String[][] board, int rowMatrix, int columnMatrix){
        boolean isPositionOccupied ;

        isPositionOccupied = !board[rowMatrix][columnMatrix].equals("   ") && !board[rowMatrix][columnMatrix].equals(" - ");

        return isPositionOccupied;
    }

    //se a posicao estiver ocupada, coloca o *, se nao coloca o -
    public static void attack(String[][] board, int rowMatrix, int columnMatrix) {
        boolean contato;
        contato = isPositionOccupied(board,rowMatrix,columnMatrix);

        if (!contato ){
            board[rowMatrix][columnMatrix] = " - ";
        } else {
            board[rowMatrix][columnMatrix] = " * ";
        }
    }

    public static String[] coordinateValidation (String coordinate){

        if (coordinate.length() != 2){
            System.out.println("Coordenada inválida!");
            System.out.println("Por favor insira apenas uma letra e um número.");
            return new String[0];
        }

        String[] splitCoordinate = coordinate.split("");
        String letterPosition = splitCoordinate[0].toUpperCase(Locale.ROOT);
        String numberPosition = splitCoordinate[1];

        String[] lettersBoard = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] numbersBoard = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        if (!Arrays.asList(lettersBoard).contains(letterPosition) || !Arrays.asList(numbersBoard).contains(numberPosition)) {
            System.out.println("Coordenada inválida!");
            System.out.println("Essa coordenada não faz parte do tabuleiro.");
            return new String[0];
        }

        String[] coordinateValid = new String[2];

        coordinateValid[0] = letterPosition;
        coordinateValid[1] = numberPosition;

        return coordinateValid;
    }

    public static int convertLetterEnterToMatrixRow(String letterPosition){
        String[] lettersBoard = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        int index = 0;
        int rowMatrix = 0;

        while (index < lettersBoard.length){
            if (letterPosition.equalsIgnoreCase(lettersBoard[index])){
                rowMatrix = (2 * index) + 2;
                break;
            }
            index ++;
        }

        return rowMatrix;
    }

    //Equanção de conversão: índiceDaMatriz = (2 * posiçãoDesejada) + 3
    public static int convertNumberEnterToMatrixColumn (String numberPosition){
        return (2 * Integer.parseInt(numberPosition) + 3);
    }

    //FUNÇÃO PARA SORTEAR O NUMERO DA LINHA DO OPONENTE
    public static int sortNumberRow () {
        Random random = new Random();
        int randomRow = random.nextInt(10);
        int rowMatrix = (2 * randomRow) + 2;
        return rowMatrix;
    }

    //FUNÇÃO PARA SORTEAR O NUMERO DA COLUNA DO OPONENTE
    public static int sortNumberColumn () {
        Random random = new Random();
        int randomColumn = random.nextInt(10);
        int columnMatrix = (2 * randomColumn) + 3;
        return columnMatrix;
    }
}
