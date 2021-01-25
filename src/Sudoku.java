import java.util.HashMap;

public class Sudoku {

    public Cell[][] getSudoku() {
        return sudoku;
    }

    private Cell[][] sudoku;
    private int n;
    private HashMap<Character, Integer> priorityMap = new HashMap<Character, Integer>();

    public HashMap<Character, Integer> getPriorityMap() {
        return priorityMap;
    }

    public Sudoku(Cell[][] sudoku, int n) {
        this.sudoku = sudoku;
        this.n = n;

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
        if (j != n - 1) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j + 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j + 1].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i][j + 1].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i][j + 1].getColor()))) {
                    return false;
                }
            }
        }
        if (i != n - 1) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i + 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i + 1][j].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i + 1][j].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i + 1][j].getColor()))) {

                    return false;
                }
            }
        }
        if (i != 0) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i - 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i - 1][j].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i - 1][j].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i - 1][j].getColor()))) {
                    return false;
                }
            }
        }
        if (j != 0) {
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j - 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j - 1].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i][j - 1].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i][j - 1].getColor()))) {

                    return false;
                }
            }
        }
        System.out.println("******************************");
        for (int k = 0; k < n; k++) {
            for (int d = 0; d < n; d++) {
//                System.out.println("sudoku = " + sudoku[i][j].getNumber());
//                System.out.println("color = " + sudoku[i][j].getColor());
                if (sudoku[k][d] != null && (d + 1) % 3 == 0) {
                    System.out.print("|" + sudoku[k][d].getNumber() + sudoku[k][d].getColor() + "|");
                } else {
                    System.out.print("|" + sudoku[k][d].getNumber() + sudoku[k][d].getColor());
                }
            }
            System.out.println();
        }
        // Everything looks good.
        return true;
    }

    public boolean CanPutColor(int i, int j, char c) {
        if (j != n - 1) {
            if (sudoku[i][j + 1].getColor() == c) {
                return false;
            }
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j + 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j + 1].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i][j + 1].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i][j + 1].getColor()))) {
                    System.out.println("i , j = " + i + j);
                    return false;
                }
            }
        }
        if (i != n - 1) {
            if (sudoku[i + 1][j].getColor() == c) {
                return false;
            }
            if (sudoku[i][j].getNumber() != '*' && sudoku[i + 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i + 1][j].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i + 1][j].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i + 1][j].getColor()))) {

                    return false;
                }
            }
        }
        if (i != 0) {
            if (sudoku[i - 1][j].getColor() == c) {
                return false;
            }
            if (sudoku[i][j].getNumber() != '*' && sudoku[i - 1][j].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i - 1][j].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i - 1][j].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i - 1][j].getColor()))) {
                    return false;
                }
            }
        }
        if (j != 0) {
            if (sudoku[i][j - 1].getColor() == c) {
                return false;
            }
            if (sudoku[i][j].getNumber() != '*' && sudoku[i][j - 1].getNumber() != '*' && sudoku[i][j].getColor() != '#' && sudoku[i][j - 1].getColor() != '#') {
                if ((sudoku[i][j].getNumber() < sudoku[i][j - 1].getNumber() && priorityMap.get(sudoku[i][j].getColor()) > priorityMap.get(sudoku[i][j - 1].getColor()))) {

                    return false;
                }
            }
        }
        System.out.println("--------------------------------");
        for (int k = 0; k < n; k++) {
            for (int d = 0; d < n; d++) {
//                System.out.println("sudoku = " + sudoku[i][j].getNumber());
//                System.out.println("color = " + sudoku[i][j].getColor());
                if (sudoku[k][d] != null && (d + 1) % 3 == 0) {
                    System.out.print("|" + sudoku[k][d].getNumber() + sudoku[k][d].getColor() + "|");
                } else {
                    System.out.print("|" + sudoku[k][d].getNumber() + sudoku[k][d].getColor());
                }
            }
            System.out.println();
        }
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
//        System.out.println("c = " + c);
//        System.out.println("num " + sudoku[i][j].getNumber());
//        System.out.println("color " + sudoku[i][j].getColor());
//        System.out.println("priority " + priorityMap.get(sudoku[i][j].getColor()));
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
                } else {
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
                if (sudoku[ii][jj].getNumber() == '*' | sudoku[ii][jj].getColor() == '#') {
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


//        System.out.println("i , j = " + i + j);
//        for (Character c : priorityMap.keySet()) {
//
//            System.out.println("------------");
//            if (CanPutColor(i, j, c)) {
//                System.out.println(i);
//                System.out.println(j);
//                System.out.println(c);
//            }
//        }


        for (Character c : priorityMap.keySet()) {
            for (int x = 1; x < n + 1; x++) {
                if (sudoku[i][j].getNumber() == '*' && sudoku[i][j].getColor() == '#') {
                    if (CanPutNum(i, j, x)) {
                        sudoku[i][j].setNumber((char) (x + '0'));
                    }
                    if (CanPutColor(i, j, c)) {
                        sudoku[i][j].setColor(c);

                    }
//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
//                    System.out.println("c = " + c);
//                    System.out.println("x = " + x);
                    if (backtrackSolve()) {
                        return true;
                    }
                    sudoku[i][j].setNumber('*');
                    sudoku[i][j].setColor('#');
                } else if (sudoku[i][j].getNumber() == '*') {
                    if (CanPutNum(i, j, x)) {
                        sudoku[i][j].setNumber((char) (x + '0'));
                        if (backtrackSolve()) {
                            return true;
                        }
                        sudoku[i][j].setNumber('*');


                    }
//                        sudoku[i][j].setNumber((char) (x + '0'));
                } else if (sudoku[i][j].getColor() == '#') {
                    if (CanPutColor(i, j, c)) {
                        sudoku[i][j].setColor(c);
                        if (backtrackSolve()) {
                            return true;
                        }
                        sudoku[i][j].setColor('#');
                    }
                }

//                if (CanPutNum(i, j, x) && CanPutColor(i , j , c)) {
////                    System.out.println("i " + i );
////                    System.out.println("j " + j );
////                    System.out.println("x " + x );
////                    System.out.println("c " + c );
////                System.out.println("(char)(x+'0') = " + (char)(x+'0'));
//                    sudoku[i][j].setNumber((char) (x + '0'));
//                    sudoku[i][j].setColor(c);
//
//                    if (backtrackSolve()) {
//                        return true;
//                    }
//
//                    sudoku[i][j].setNumber('*'); // We've failed.
//                    sudoku[i][j].setColor('#');
//                }
            }

        }

        return false; // Backtracking
    }


}
