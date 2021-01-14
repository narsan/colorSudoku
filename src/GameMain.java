import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;


public class GameMain {
    private static ArrayList<Cell> sudoku = new ArrayList<>();

    private static int get_Input() {
        char number;
        char color;

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] colors = sc.nextLine().split(" ");
        Integer m = Integer.valueOf(input[0]);
        Integer n = Integer.valueOf(input[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String val = sc.next();
                color = val.charAt(1);
                number = val.charAt(0);
                Cell cell = new Cell(number, color);
                sudoku.add(cell);
            }
        }
        return n;
    }

    private static void print_Board(int n) {
        for (int i = 0; i < sudoku.size(); i++) {
            if (i % sqrt(sudoku.size()) == 0) {
                System.out.print("\n");
            }

            if (sudoku.get(i) == null)
                System.out.print("| ");
            else if (sudoku.get(i) != null && (i + 1) % 3 == 0) {
                System.out.print("|" + sudoku.get(i).getNumber() + sudoku.get(i).getColor() + "|");
            } else {
                System.out.print("|" + sudoku.get(i).getNumber() + sudoku.get(i).getColor());
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