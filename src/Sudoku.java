public class Sudoku {

    public Cell[][] getSudoku() {
        return sudoku;
    }

    private Cell[][] sudoku;
    private int n ;

    public Sudoku (Cell[][] sudoku , int n ){
        this.sudoku = sudoku;
        this.n = n;

    }
    public boolean CanPutNum(int i, int j, int x) {

        // Is 'x' used in row.
        for (int jj = 0; jj < n; jj++) {
            if (sudoku[i][jj].getNumber() == (char)(x+'0')) {
                return false;
            }
        }

        // Is 'x' used in column.
        for (int ii = 0; ii < n; ii++) {
            if (sudoku[ii][j].getNumber() == (char)(x+'0')) {
                return false;
            }
        }
        // Everything looks good.
        return true;
    }

    public void solve() {

        if (!backtrackSolve()) {
            System.out.println("This sudoku can't be solved.");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.println("sudoku = " + sudoku[i][j].getNumber());
//                System.out.println("color = " + sudoku[i][j].getColor());
                if (sudoku[i][j] != null && (j + 1) % 3 == 0) {
                    System.out.print("|" + sudoku[i][j].getNumber() + sudoku[i][j].getColor() + "|");
                }
                else {
                    System.out.print("|" + sudoku[i][j].getNumber() + sudoku[i][j].getColor());
                }
            }
            System.out.println();
        }
    }


    public boolean backtrackSolve() {
        int i = 0, j = 0;
        boolean isThereEmptyCell = false;

        for (int ii = 0; ii < n && !isThereEmptyCell; ii++) {
            for (int jj = 0; jj < n && !isThereEmptyCell; jj++) {
                if (sudoku[ii][jj].getNumber() == '*') {
                    isThereEmptyCell = true;
                    i = ii;
                    j = jj;
                }
            }
        }

        // We've done here.
        if (!isThereEmptyCell) {
            return true;
        }

        for (int x = 1; x < 10; x++) {

            if (CanPutNum(i, j, x)) {
//                System.out.println("(char)(x+'0') = " + (char)(x+'0'));
                sudoku[i][j].setNumber((char)(x+'0'));

                if (backtrackSolve()) {
                    return true;
                }

                sudoku[i][j].setNumber('*'); // We've failed.
            }

        }

        return false; // Backtracking
    }

}
