import java.util.ArrayList;
import java.util.Scanner;



public class GameMain {
//    private static Cell[][] sudoku = new Cell[1000][1000];
    private static ArrayList<Cell> sudoku = new ArrayList<>();

    private static int get_Input() {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] colors = sc.nextLine().split(" ");
        Integer m = Integer.valueOf(input[0]);
        Integer n = Integer.valueOf(input[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String val = sc.next();
                System.out.println("val[0] = " + val.charAt(0));
                System.out.println("val[1] = " + val.charAt(1));
                System.out.println("val.length = " + val.length());
                int number = val.charAt(0);
                char color = val.charAt(1);
                Cell cell = new Cell(number , color);
                sudoku.add(cell);
//                System.out.println("sudoku = " + sudoku[i][j].getNumber());
            }
        }
        return n;
    }

//    private static void print_Board(int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.print("\n");
//            for (int j = 0; j < n + 1; j++) {
//                if (sudoku[i][j] == null)
//                    System.out.print("| ");
//                else {
//                    System.out.print("|" + sudoku[i][j].getNumber()+ sudoku[i][j].getColor());
//                }
//            }
//        }
//    }

    public static void main(String[] args) {

        int n = get_Input();
        //print_Board(n);
    }
}

//3 3
//y g r
//1r 2g 3y
//2g 3y 1r
//3r 1g 2y