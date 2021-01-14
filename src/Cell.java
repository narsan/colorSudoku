public class Cell {
    private int number;
    private char color;


    public Cell (int number , char color){
        this.number = number ;
        this.color = color ;
    }

    public int getNumber() {
        return number;
    }

    public char getColor() {
        return color;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
