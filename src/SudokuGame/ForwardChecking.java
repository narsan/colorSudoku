package SudokuGame;

import java.util.ArrayList;

public class ForwardChecking {
    public int n;

    public ForwardChecking(int n) {
        this.n = n;
    }

    public Sudoku forwardChecking(Sudoku sudoku) {
        Sudoku sudokuToCheck = sudoku;
        isValid(sudokuToCheck, 0);
        return sudokuToCheck;

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

    public boolean isValid(Sudoku sudoku, int pos) {
        if (pos == n * n) {
            return true;
        }
        int i = pos / n;
        int j = pos % n;
//        System.out.println("in fc");
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
        if (sudoku.getSudoku()[i][j].getColor() != '#' && sudoku.getSudoku()[i][j].getNumber() != '*') {
            return isValid(sudoku, pos + 1);
        }

        if (sudoku.getSudoku()[i][j].getNumber() == '*' && sudoku.getSudoku()[i][j].getColor() == '#') {
            for (String s : CreateDomain(sudoku, i, j)) {
                char c = s.charAt(1);
                int x = Character.getNumericValue(s.charAt(0));
                sudoku.getSudoku()[i][j].setColor(c);
                sudoku.getSudoku()[i][j].setNumber((char) (x + '0'));
//                if (sudoku.CanPutNum(i, j, x) && sudoku.CanPutColor(i, j, c)) {
                if (sudoku.CheckNeighbour(i, j)) {
                    if (isValid(sudoku, pos + 1)) {
                        return true;
//                        } else {
////                            sudoku.getSudoku()[i][j].getDomain().remove(s);
////                            return false;
//                        }
                    }
                }

            }
            sudoku.getSudoku()[i][j].setNumber('*');
            sudoku.getSudoku()[i][j].setColor('#');

        } else if (sudoku.getSudoku()[i][j].getNumber() == '*') {
            for (String s : CreateDomain(sudoku, i, j)) {
                if (sudoku.CanPutNum(i, j, s.charAt(0))) {
                    if (sudoku.CheckNeighbour(i, j)) {
                        sudoku.getSudoku()[i][j].setNumber(s.charAt(0));

                        if (isValid(sudoku, pos + 1)) {
                            return true;
//                        } else {
////                            sudoku.getSudoku()[i][j].getDomain().remove(s);
////                            return false;
                        }
                    }
                }

            }
            sudoku.getSudoku()[i][j].setNumber('*');
        } else if (sudoku.getSudoku()[i][j].getColor() == '#') {
            for (String s : CreateDomain(sudoku, i, j)) {
                sudoku.getSudoku()[i][j].setColor(s.charAt(0));
                if (sudoku.CanPutColor(i, j, s.charAt(0))) {
                    if (sudoku.CheckNeighbour(i, j)) {
                        if (isValid(sudoku, pos + 1)) {
                            return true;
//                        } else {
//                            sudoku.getSudoku()[i][j].getDomain().remove(s);
//                            return false;
                        }
                    }
                }

            }
            sudoku.getSudoku()[i][j].setColor('#');
        }
        return false;
    }
}
