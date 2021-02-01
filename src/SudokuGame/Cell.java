package SudokuGame;

class Cell {
    private char number;
    private char color;
    int n ;

    public Cell (char number , char color , int n){
        this.number = number ;
        this.color = color ;
        this.n = n ;
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
