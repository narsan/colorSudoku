package SudokuGame;


import java.util.ArrayList;
import java.util.Scanner;

public class MRV {
    public int n;

    public MRV(int n) {
        this.n = n;
    }

    public Sudoku MRVSearch(Sudoku sudoku) {
        if (!isValid(sudoku)) {
            System.out.println("this suduko cannot be solved");
            return null;
        }

        return sudoku;
    }

    public ArrayList<String> CreateDomain(Sudoku sudoku, int i, int j) {
        ArrayList<String> domain = new ArrayList<>();
        if (sudoku.getSudoku()[i][j].getNumber() == '*' && sudoku.getSudoku()[i][j].getColor() == '#') {
            for (int x = 1; x < n + 1; x++) {
                for (Character c : sudoku.getPriorityMap().keySet()) {
                    if (sudoku.CanPutColor(i, j, c) && sudoku.CanPutNum(i, j, x)) {
                        if (sudoku.CheckNeighbour(i, j)) {
                            String temp = x + "" + c;
                            domain.add(temp);
                        }
                    }
                }
            }
        } else if (sudoku.getSudoku()[i][j].getNumber() == '*') {
            for (int x = 1; x < n + 1; x++) {
                if (sudoku.CanPutNum(i, j, x)) {
                    if (sudoku.CheckNeighbour(i, j)) {
                        String temp = x + "";
                        domain.add(temp);
                    }
                }
            }
        } else if (sudoku.getSudoku()[i][j].getColor() == '#') {
            for (Character c : sudoku.getPriorityMap().keySet()) {
                if (sudoku.CanPutColor(i, j, c)) {
                    if (sudoku.CheckNeighbour(i, j)) {
                        String temp = c + "";
                        domain.add(temp);
                    }
                }
            }
        }
        return domain;
    }

    public boolean isValid(Sudoku sudoku) {
        int i = 0, j = 0;
        int minimum = n * sudoku.getPriorityMap().keySet().size() + 1;
        int temp;

        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < n; jj++) {
                if (sudoku.getSudoku()[ii][jj].getNumber() == '*' | sudoku.getSudoku()[ii][jj].getColor() == '#') {
                    temp = CreateDomain(sudoku, ii, jj).size();
                    if (temp < minimum) {
                        minimum = temp;
                        i = ii;
                        j = jj;
                    }
                }
            }
        }

        if (minimum == n * sudoku.getPriorityMap().keySet().size() + 1) {
            return true;
        }
        if (sudoku.getSudoku()[i][j].getNumber() == '*' && sudoku.getSudoku()[i][j].getColor() == '#') {
            for (String s : CreateDomain(sudoku, i, j)) {
                char c = s.charAt(1);
                int x = Character.getNumericValue(s.charAt(0));
                sudoku.getSudoku()[i][j].setNumber((char) (x + '0'));
                sudoku.getSudoku()[i][j].setColor(c);
                if (sudoku.CheckNeighbour(i, j)) {
                    if (isValid(sudoku)) {
                        return true;
                    }
                }
            }
            sudoku.getSudoku()[i][j].setNumber('*');
            sudoku.getSudoku()[i][j].setColor('#');

        }
        if (sudoku.getSudoku()[i][j].getNumber() == '*' && sudoku.getSudoku()[i][j].getColor() != '#') {
            for (String s : CreateDomain(sudoku, i, j)) {
                sudoku.getSudoku()[i][j].setNumber(s.charAt(0));
                if (sudoku.CheckNeighbour(i, j)) {
                    if (isValid(sudoku)) {
                        return true;
                    }
                }
            }
            sudoku.getSudoku()[i][j].setNumber('*');
        }
        if (sudoku.getSudoku()[i][j].getColor() == '#' && sudoku.getSudoku()[i][j].getNumber() != '*') {
            for (String s : CreateDomain(sudoku, i, j)) {
                sudoku.getSudoku()[i][j].setColor(s.charAt(0));
                if (sudoku.CheckNeighbour(i, j)) {
                    if (isValid(sudoku)) {
                        return true;
                    }
                }
            }
            sudoku.getSudoku()[i][j].setColor('#');
        }
        return false;


    }
}
