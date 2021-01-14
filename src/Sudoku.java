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
            if (sudoku[i][jj].getNumber() == 'x') {
                return false;
            }
        }

        // Is 'x' used in column.
        for (int ii = 0; ii < n; ii++) {
            if (sudoku[ii][j].getNumber() == 'x') {
                return false;
            }
        }
        // Everything looks good.
        return true;
    }

}
