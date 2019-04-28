package tictactoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

//package tictactoe;

/**
 *
 * @author nagimohsen
 */
public class TicTacToe {

    char[][] table = new char[3][3];

    public void initializeGame() {
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                table[i][p] = ' ';
            }
        }
    }


    public boolean checkIfLegal(int row, int column) {
        if ((row > 2 || column > 2) || (row < 0 || column < 0)) {
            return true;
        } else if (table[row][column] == 'x' || table[row][column] == 'o') {
            return true;
        }

        return false;
    }


    public void changeBoard(char player, int row, int column) {
        table[row][column] = player;

    }


    public void displayBoard() {
        int count=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                count++;
                if(table[i][j]==' ')
                    System.out.print(count + " ");
                else
                    System.out.print(table[i][j]+ " ");
            }
            System.out.println();
        }
    }


    public char changePlayer(char player) {
        char newTurn = 'e';
        if (player == 'o') {
            newTurn = 'x';
        }
        if (player == 'x') {
            newTurn = 'o';
        }
        return newTurn;
    }


    public boolean checkIfWinner() {
        if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && (table[0][0] == 'x' || table[0][0] == 'o')) {
            return true;
        } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && (table[0][1] == 'x' || table[0][1] == 'o')) {
            return true;
        } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && (table[0][2] == 'x' || table[0][2] == 'o')) {
            return true;
        } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && (table[0][0] == 'x' || table[0][0] == 'o')) {
            return true;
        } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && (table[1][0] == 'x' || table[1][0] == 'o')) {
            return true;
        } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && (table[2][0] == 'x' || table[2][0] == 'o')) {
            return true;
        } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && (table[0][0] == 'x' || table[0][0] == 'o')) {
            return true;
        } else if (table[2][0] == table[1][1] && table[1][1] == table[0][2] && (table[2][0] == 'x' || table[2][0] == 'o')) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkIfTie() {
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                if (table[i][p] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }



    public static void main(String[] args) {
        
        
        char player = 'o';
        int row= -1, column= -1;
        Scanner k = new Scanner(System.in);
        TicTacToe g = new TicTacToe();

        g.initializeGame();
        System.out.println("Game ready !\n");

        System.out.println("Board: ");
        g.displayBoard();

        while (true) {
            player = g.changePlayer(player);
            System.out.print("Current Player Is " + player + ", Please select your number: ");
            int locationNumber = k.nextInt();
            int index[] = getRowAndColumn(locationNumber);
            row = index[0];
            column = index[1];
            while (g.checkIfLegal(row, column)) {
                System.out.println("Sorry, That slot is either taken or out of bounds, please try a new location: ");
                g.displayBoard();
                System.out.print("Current Player Is " + player + " ,Select your number: ");
                locationNumber = k.nextInt();
                index = getRowAndColumn(locationNumber);
                row = index[0];
                column = index[1];
            }
            g.changeBoard(player, row, column);
            g.displayBoard();

            if (g.checkIfWinner()) {
                System.out.println("\nThe winner is " + player + " !");
                break;

            }
            if (g.checkIfTie()) {
                System.out.println("\nThe game is a tie !");
                break;
            }
        }


    }

    private static int[] getRowAndColumn(int locationNumber) {
        int[] index = {-1,-1};

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(i*3+j+1 == locationNumber)
                {
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
            if(index[0]!=-1 && index[1]!=-1)
                break;

        }
        return index;
    }
}
    

