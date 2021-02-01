package SudokuGame;

import java.util.*;



class Sudoku {
    private Cell[][] sudoku;
    public int n;
    private Map<Character, Integer> priorityMap = new LinkedHashMap<>();

    public Sudoku(Cell[][] sudoku, int n ) {
        this.sudoku = sudoku;
        this.n = n;
    }

    public Cell[][] getSudoku() {
        return sudoku;
    }


    public Map<Character, Integer> getPriorityMap() {
        return priorityMap;
    }

    public boolean CanPutNum(int i, int j, int x) {

        // Is 'x' used in row.
        for (int jj = 0; jj < n; jj++) {
            if (sudoku[i][jj].getNumber() == (char) (x + '0')) {
                return false;
            }
        }

        // Is 'x' used in column.
        for (int ii = 0; ii < n; ii++) {
            if (sudoku[ii][j].getNumber() == (char) (x + '0')) {
                return false;
            }
        }

        // Everything looks good.
        return true;
    }


    public boolean CanPutColor(int i, int j, char c) {
        if (j != n - 1) {
            if (sudoku[i][j + 1].getColor() == c) {
                return false;
            }
        }
        if (i != n - 1) {
            if (sudoku[i + 1][j].getColor() == c) {
                return false;
            }
        }
        if (i != 0) {
            if (sudoku[i - 1][j].getColor() == c) {
                return false;
            }
        }
        if (j != 0) {
            if (sudoku[i][j - 1].getColor() == c) {
                return false;
            }
        }

        return true;
    }

    public boolean CheckNeighbour(int i, int j) {
        if (j != n - 1) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j + 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j + 1].getColor() != '#') {
                if (sudoku[i][j].getNumber() < sudoku[i][j + 1].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i][j + 1].getColor())) {
                        return false;
                    }
                }
            }
        }
        if (j != n - 1) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j + 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j + 1].getColor() != '#') {
                if (sudoku[i][j].getNumber() > sudoku[i][j + 1].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) < priorityMap.get(sudoku[i][j + 1].getColor())) {
                        return false;
                    }
                }
            }
        }
        if (i != n - 1) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i + 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i + 1][j].getColor() != '#') {
                if (sudoku[i][j].getNumber() < sudoku[i + 1][j].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i + 1][j].getColor())) {

                        return false;
                    }
                }
            }
        }
        if (i != n - 1) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i + 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i + 1][j].getColor() != '#') {
                if (sudoku[i][j].getNumber() > sudoku[i + 1][j].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) < priorityMap.get(sudoku[i + 1][j].getColor())) {

                        return false;
                    }
                }
            }
        }
        if (i != 0) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i - 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i - 1][j].getColor() != '#') {
                if (sudoku[i][j].getNumber() < sudoku[i - 1][j].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i - 1][j].getColor())) {
                        return false;
                    }
                }
            }
        }
        if (i != 0) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i - 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i - 1][j].getColor() != '#') {
                if (sudoku[i][j].getNumber() > sudoku[i - 1][j].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) < priorityMap.get(sudoku[i - 1][j].getColor())) {
                        return false;
                    }
                }
            }
        }
        if (j != 0) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j - 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j - 1].getColor() != '#') {
                if (sudoku[i][j].getNumber() < sudoku[i][j - 1].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i][j - 1].getColor())) {

                        return false;
                    }
                }
            }
        }
        if (j != 0) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j - 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j - 1].getColor() != '#') {
                if (sudoku[i][j].getNumber() > sudoku[i][j - 1].getNumber()) {
                    if (priorityMap.get(sudoku[i][j].getColor()) < priorityMap.get(sudoku[i][j - 1].getColor())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

