public class Letter implements ILetter {

    private final char character;

    public Letter(char character) {
        this.character = character;
    }

    @Override
    public void display(int row, int column) {
        System.out.println("Displaying character '" + character + "' at position (" + row + ", " + column + ")");
    }
    
}
