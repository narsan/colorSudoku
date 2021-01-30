import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    private char number;
    private char color;
    private ArrayList <String> domain = new ArrayList<>();

    public ArrayList<String> getDomain() {
        return domain;
    }

    public Cell (char number , char color){
        this.number = number ;
        this.color = color ;
    }

    public void setNumber(char number) {
        this.number = number;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getNumber() {
        return number;
    }

    public char getColor() {
        return color;
    }


}
