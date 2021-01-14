public class Cell {
    private char number;
    private char color;


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
