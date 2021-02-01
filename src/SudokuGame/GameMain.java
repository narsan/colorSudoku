package SudokuGame;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGame {
    private static Sudoku sudoku;

    private static int get_Input() {
        char number;
        char color;
        ArrayList<String> domain0;
        ArrayList<String> domain1;
        ArrayList<String> domain2;

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] colors = sc.nextLine().split(" ");
        // HashMap <Character , Integer> priorityMap = new HashMap <Character, Integer>();

        Integer m = Integer.valueOf(input[0]);
        Integer n = Integer.valueOf(input[1]);
        sudoku = new Sudoku(new Cell[n][n], n);
        for (int i = 0; i < colors.length; i++) {
            sudoku.getPriorityMap().put(colors[colors.length - i - 1].charAt(0), i + 1);
        }

//        System.out.println(sudoku.getPriorityMap());
//        System.out.println(sudoku.getPriorityMap().get('b'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String val = sc.next();
                color = val.charAt(1);
                number = val.charAt(0);
                Cell cell = new Cell(number, color, n);
                sudoku.getSudoku()[i][j] = cell;
            }
        }

        return n;
    }

    private static void printBoard(int n, Cell[][] c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (c[i][j] != null && (j + 1) % n == 0) {
                    System.out.print("|" + c[i][j].getNumber() + c[i][j].getColor() + "|");
                } else {
                    System.out.print("|" + c[i][j].getNumber() + c[i][j].getColor());
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = get_Input();
        Sudoku sudokuToSolve;
        Sudoku sudokuToSolve1;
        Sudoku sudokuToSolve2;
        BackTracking bt = new BackTracking(n);
        ForwardChecking fc = new ForwardChecking(n);
        MRV mrv = new MRV(n);
        sudokuToSolve = mrv.MRVSearch(sudoku);
        if (sudokuToSolve == null) {
            printBoard(n, sudoku.getSudoku());
        } else {
            sudokuToSolve1 = fc.forwardChecking(sudokuToSolve);
            sudokuToSolve2 = bt.backTracking(sudokuToSolve1);


//        printBoard(n , sudokuToSolve.getSudoku());
//        printBoard(n , sudokuToSolve1.getSudoku());
//        printBoard(n , sudokuToSolve1.getSudoku());
            printBoard(n, sudokuToSolve2.getSudoku());
//        mrv.solve(sudoku);
        }

    }
}
