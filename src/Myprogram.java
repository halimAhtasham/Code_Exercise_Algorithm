import java.util.*;

class Nqueen {

    int n;
    int[][] board;
    int count_recursive, count_backtrack;

    Nqueen(int total) {
        n = total;
        board = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                board[i][j] = 0;

        count_recursive = count_backtrack = 0;

    } // end of constructor

    void display() {
        int i, j;
        System.out.println("Current board is ");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            } // j loop
            System.out.println();
        } // i loop
    } // end of display()

    boolean checksafe(int row, int col) {
        int i, j;

        // upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        // left, same row
        i = row; // same row, no change of i
        for (j = col; j >= 0; j--) {
            if (board[i][j] == 1)
                return false;
        }
        // lower left diagonal
        for (i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // we don't need to check right side of current row,col
        // as no queen is there

        // safecheck successfull
        return true;
    } // end of checksafe method

    boolean solvenqueen(int col) {
        count_recursive++;

        if (col == n) // all queens are marked, solved
            return true;

        int row;
        for (row = 0; row < n; row++) { // try each row of cureent column
            boolean x;
            x = checksafe(row, col);
            if (x == false)
                continue; // current (row,col) no safe, start next row
            else {
                board[row][col] = 1; // temp. successful

                boolean y;
                y = solvenqueen(col + 1); // try next column, each row
                if (y == false) {
                    count_backtrack++;
                    board[row][col] = 0;
                } // backtrack
                else
                    return true;
            } // end of else

        } // try next row iteration util loop finished

        // as loop completed, all tried with no success
        count_backtrack++;
        return false;
    } // end of solvequeen method

    void startsolve() {
        int col;
        col = 0;

        boolean z;
        z = solvenqueen(col);
        if (z == false)
            System.out.println("No solution");
        else {
            System.out.println("Solution is");
            display();
        }
        System.out.println("Total recursive call " + count_recursive);
        System.out.println("Total backtrack " + count_backtrack);
    } // end of startsolve method

}// end of Nqeen class

public class Myprogram {
    public static void main(String[] args) {
        Scanner s;
        s = new Scanner(System.in);

        int total;
        System.out.println("How many queens?");
        total = s.nextInt();

        Nqueen a;
        a = new Nqueen(total);
        a.startsolve();

    } // main
}// end of Myprogram class