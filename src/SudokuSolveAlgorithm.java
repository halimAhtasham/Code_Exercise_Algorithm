import java.util.*;

///////////////////////////////
class Sudoku {

    int[][] board;
    int n;
    int counterRecursive, counterBacktrack;

    Sudoku() {
        n = 9;
        counterRecursive = 0;
        counterBacktrack = 0;
        board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 0, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
    }

    void printboard() {
        int i, j;
        for (i = 0; i < n; i++) {
            if (i > 0 && i % 3 == 0) {
                System.out.println();
                System.out.print("---------------------"); // 22 symbols
            }

            System.out.println();
            for (j = 0; j < n; j++) {
                if (j > 0 && j % 3 == 0)
                    System.out.print(" |");
                if (board[i][j] <= 0)
                    System.out.print(". ");
                else
                    System.out.print(board[i][j] + " ");
            } // inner loop
        } // outer loop
        System.out.println();
    }

    boolean checkSafe(int row, int col, int num) {
        int i, j;
        // check rowwise
        for (j = 0; j < n; j++)
            if (board[row][j] == num)
                return false; // the row has same number

        // check columnwise
        for (i = 0; i < n; i++)
            if (board[i][col] == num)
                return false; // the column has same number

        /// checking a box
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (i = boxStartRow; i < boxStartRow + 3; i++)
            for (j = boxStartCol; j < boxStartCol + 3; j++)
                if (board[i][j] == num)
                    return false; // box contains same number
        return true;
    }

    boolean sudokuSolver() {
        int row = 0; // must be initialized;otherwise compiletime error
        int col = 0;
        int i, j, num; // for loop

        boolean solved = true; // initially
        counterRecursive++;

        ///////////// base part ///////////////////
        // check if all cells are solved

        loop1: for (i = 0; i < n; i++) {
            loop2: for (j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    solved = false;
                    break loop1;
                } // if

            } // inner loop
        } // outer loop
        if (solved == true) {
            System.out.println("\t Sudoku Solved");
            return true; // solved
        }

        //////////////////// recursive/backtrack part //////////////////

        for (num = 1; num <= n; num++) {
            if (checkSafe(row, col, num) == true) {
                board[row][col] = num;
                if (sudokuSolver() == true) // successful, so recursive call next step
                {
                    return true;
                } else {
                    board[row][col] = 0; // backtrack, try with next number
                    counterBacktrack++;
                }
            }
        } // loop for numbers
        return false;
    }

} // end of Sudoku class

public class SudokuSolveAlgorithm {

    public static void main(String[] args) {

        Sudoku s = new Sudoku();
        System.out.println("\t Given board");
        s.printboard();

        System.out.println("\t Solving...");
        boolean b = s.sudokuSolver();
        if (b == false)
            System.out.println("\t Could not be solved. Invalid data");
        else
            s.printboard();

        System.out.print("\n\t Recursive call " + s.counterRecursive);
        System.out.println("\t Backtrack " + s.counterBacktrack);
    }

}