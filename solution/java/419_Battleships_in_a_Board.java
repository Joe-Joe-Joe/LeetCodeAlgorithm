//Problem description
//Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. 
//You may assume the following rules:
/*
    You receive a valid board, made of only battleships or empty slots.
    Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
    At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
*/

public class Solution {
    public boolean isBoard(int x, int y, char[][] board) {
        if(x >= 0 && y >= 0) {
            if(board[x][y] == 'X') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public int countBattleships(char[][] board) {
        
        int sum = 0;
        int iSize = board.length;
        int jSize = board[0].length;
        
        for(int i = 0; i < iSize; i++) {
            for(int j = 0; j < jSize; j++) {
                if(board[i][j] == 'X') {
                    if(isBoard(i - 1, j, board) == false && isBoard(i, j - 1, board) == false) {
                        sum += 1;
                    }
                }
            }
        }
        return sum;       
    }
}