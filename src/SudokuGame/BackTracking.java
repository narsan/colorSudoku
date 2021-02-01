package SudokuGame;

public class BackTracking {
    public int n;

    public BackTracking(int n) {
        this.n = n;
    }

    public Sudoku backTracking(Sudoku sudoku) {
        Sudoku sudokuToCheck = sudoku;
        isValid(sudokuToCheck, 0);
        return sudokuToCheck;

    }

    public boolean isValid(Sudoku sudoku, int pos) {
        if (pos == n * n) {
            return true;
        }
        int i = pos / n;
        int j = pos % n;
        if (sudoku.getSudoku()[i][j].getColor() != '#' && sudoku.getSudoku()[i][j].getNumber() != '*') {
            return isValid(sudoku, pos + 1);
        }
        if (sudoku.getSudoku()[i][j].getNumber() == '*' && sudoku.getSudoku()[i][j].getColor() == '#') {
            for (int x = 1; x < n + 1; x++) {
                for (Character c : sudoku.getPriorityMap().keySet()) {
                    if (sudoku.CanPutColor(i, j, c) && sudoku.CanPutNum(i, j, x)) {
                        if (sudoku.CheckNeighbour(i, j)) {
                            sudoku.getSudoku()[i][j].setColor(c);
                            sudoku.getSudoku()[i][j].setNumber((char) (x + '0'));
                            if (isValid(sudoku, pos + 1)) {
                                return true;
                            } else {
                                sudoku.getSudoku()[i][j].setNumber('*');
                                sudoku.getSudoku()[i][j].setColor('#');
                            }
                        }
                    }
                }
            }
        } else if (sudoku.getSudoku()[i][j].getNumber() == '*') {
            for (int x = 1; x < n + 1; x++) {
                if (sudoku.CanPutNum(i, j, x)) {
                    if (sudoku.CheckNeighbour(i, j)) {
                        sudoku.getSudoku()[i][j].setNumber((char) (x + '0'));
                        if (isValid(sudoku, pos + 1)) {
                            return true;
                        }
                        sudoku.getSudoku()[i][j].setNumber('*');
                    }
                }
            }
        } else if (sudoku.getSudoku()[i][j].getColor() == '#') {
            for (Character c : sudoku.getPriorityMap().keySet()) {
                if (sudoku.CanPutColor(i, j, c)) {
                    if (sudoku.CheckNeighbour(i, j)) {
                        sudoku.getSudoku()[i][j].setColor(c);
                        if (isValid(sudoku, pos + 1)) {
                            return true;
                        }
                        sudoku.getSudoku()[i][j].setColor('#');
                    }
                }
            }
        }
        return false;
    }
}
