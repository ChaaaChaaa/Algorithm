package boj;

import java.util.Scanner;

class Q1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] chessElement = new char[8][8];
        WhiteBoard whiteBoard = new WhiteBoard(chessElement);

        for (int i = 0; i < 8; i++) {
            String chessBoard = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                whiteBoard.inputArrToChessPieces(i, j,chessBoard);
                whiteBoard.countPiecesOnWhiteBoard(i, j);
            }
        }
        whiteBoard.printResult();
    }
}

class WhiteBoard {
    private char[][] chessElement;
    private int piecesOnWhiteBoard = 0;

    WhiteBoard(char[][] chessElement) {
        this.chessElement = chessElement;
    }

    void inputArrToChessPieces(int i, int j, String chessBoard) {
        chessElement[i][j] = chessBoard.charAt(j);
    }


    void countPiecesOnWhiteBoard(int i, int j) {
        if (chessElement[i][j] == 'F' && (i + j) % 2 == 0) {
            piecesOnWhiteBoard++;
        }
    }

    void printResult() {
        System.out.println(piecesOnWhiteBoard);
    }
}
