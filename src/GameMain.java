import java.util.ArrayList;
import java.util.Scanner;



public class GameMain {
    private static Sudoku sudoku;

    private static int get_Input() {
        char number;
        char color;

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] colors = sc.nextLine().split(" ");
        Integer m = Integer.valueOf(input[0]);
        Integer n = Integer.valueOf(input[1]);
        sudoku = new Sudoku(new Cell[n][n], n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String val = sc.next();
                color = val.charAt(1);
                number = val.charAt(0);
                Cell cell = new Cell(number, color);
                sudoku.getSudoku()[i][j] = cell;
            }
        }
        return n;
    }

    private static void print_Board(int n) {
        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            System.out.print("\n");
            for (int j = 0; j < sudoku.getSudoku().length; j++) {

                if (sudoku.getSudoku()[i][j] == null)
                    System.out.print("| ");
                else if (sudoku.getSudoku()[i][j] != null && (j + 1) % 3 == 0) {
                    System.out.print("|" + sudoku.getSudoku()[i][j].getNumber() + sudoku.getSudoku()[i][j].getColor() + "|");
                }else {
                    System.out.print("|" + sudoku.getSudoku()[i][j].getNumber() + sudoku.getSudoku()[i][j].getColor());
                }

            }
        }
    }


    public static void main(String[] args) {

        int n = get_Input();
        print_Board(n);
    }
}

//3 3
//y g r
//*# 2g 3y
//2g 3y 1r
//3r 1g 2y