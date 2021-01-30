import java.util.*;

public class Sudoku {

    public Map<Character, Integer> priorityMap = new LinkedHashMap<>();

    public Cell[][] getSudoku() {
        return sudoku;
    }

    private Cell[][] sudoku;
    public int n;

    public Map<Character, Integer> getPriorityMap() {
        return priorityMap;
    }

    public Sudoku(Cell[][] sudoku, int n) {
        this.sudoku = sudoku;
        this.n = n;

    }

    public void CreateDomain(int i, int j) {
        for (int x = 1; x < n + 1; x++) {
            for (Character c : priorityMap.keySet()) {
                String temp = x + "" + c;
                sudoku[i][j].getDomain().add(temp);
            }
        }
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

    public boolean CanPut(int i, int j, int x, char c) {

        // Is 'x' used in row.
        for (int jj = 0; jj < n; jj++) {
            if (sudoku[i][jj].getNumber() == (char) (x + '0')) {
                for (Character clr : priorityMap.keySet()) {
                    String temp = x + "" + clr;
                    sudoku[i][j].getDomain().removeAll(Collections.singleton(temp));

                }
                return false;
            }
        }

        // Is 'x' used in column.
        for (int ii = 0; ii < n; ii++) {
            if (sudoku[ii][j].getNumber() == (char) (x + '0')) {
                for (Character clr : priorityMap.keySet()) {
                    String temp = x + "" + clr;
                    sudoku[i][j].getDomain().removeAll(Collections.singleton(temp));

                }

                return false;
            }
        }
        if (j != n - 1) {
            if (sudoku[i][j + 1].getColor() == c) {
                for (int num = 1; num < n + 1; num++) {
                    String temp = num + "" + c;
                    sudoku[i][j].getDomain().removeAll(Collections.singleton(temp));
                }
                return false;
            }
        }
        if (i != n - 1) {
            if (sudoku[i + 1][j].getColor() == c) {
                for (int num = 1; num < n + 1; num++) {
                    String temp = num + "" + c;
                    sudoku[i][j].getDomain().removeAll(Collections.singleton(temp));
                }
                return false;
            }
        }
        if (i != 0) {
            if (sudoku[i - 1][j].getColor() == c) {
                for (int num = 1; num < n + 1; num++) {
                    String temp = num + "" + c;
                    sudoku[i][j].getDomain().removeAll(Collections.singleton(temp));
                }
                return false;
            }
        }
        if (j != 0) {
            if (sudoku[i][j - 1].getColor() == c) {
                for (int num = 1; num < n + 1; num++) {
                    String temp = num + "" + c;
                    sudoku[i][j].getDomain().removeAll(Collections.singleton(temp));
                }
                return false;
            }
        }
        // Everything looks good.
        return true;
    }


    public void solve() {

        if (!backtrackSolve()) {
            System.out.println("This sudoku can't be solved.");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudoku[i][j] != null && (j + 1) % n == 0) {
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

        CreateDomain(i, j);


        // We've done here.
        if (!isThereEmptyCell) {
            return true;
        }
        if (sudoku[i][j].getNumber() == '*' && sudoku[i][j].getColor() == '#') {
            for (int k = 0; k < sudoku[i][j].getDomain().size(); k++) {
                char c = sudoku[i][j].getDomain().get(k).charAt(1);
                int x = Character.getNumericValue(sudoku[i][j].getDomain().get(k).charAt(0));
                if (CanPut(i, j, x, c)) {
                    sudoku[i][j].setColor(c);
                    sudoku[i][j].setNumber((char) (x + '0'));
                    if (CheckNeighbour(i, j)) {
                        if (backtrackSolve()) {
                            return true;
                        }
                    } else {
                        sudoku[i][j].setNumber('*');
                        sudoku[i][j].setColor('#');
                    }

                }
            }
        }

        else if (sudoku[i][j].getNumber() == '*') {
            for (int x = 1; x < n + 1; x++) {
                if (CanPutNum(i, j, x)) {
                    sudoku[i][j].setNumber((char) (x + '0'));
                    if (CheckNeighbour(i, j)) {
                        if (backtrackSolve()) {
                            return true;
                        }
                    }
                    sudoku[i][j].setNumber('*');
                }

            }
        } else if (sudoku[i][j].getColor() == '#') {
            for (Character c : priorityMap.keySet()) {
                if (CanPutColor(i, j, c)) {
                    sudoku[i][j].setColor(c);
                    if (CheckNeighbour(i, j)) {
                        if (backtrackSolve()) {
                            return true;
                        }
                    }
                    sudoku[i][j].setColor('#');
                }
            }
        }
        return false;
    }
}

