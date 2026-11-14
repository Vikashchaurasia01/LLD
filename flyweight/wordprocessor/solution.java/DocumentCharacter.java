public class DocumentCharacter implements ILetter {
    // Intrinsic data - shared data - common to all objects

    private final char character;
    private final String fontFamily;
    private final int fontSize;

    public DocumentCharacter(char character, String fontFamily, int fontSize) {
        this.character = character;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    // getter methods only
    public char getCharacter() {
        return character;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getFontSize() {
        return fontSize;
    }

    @Override 
    public void display(int row, int column) {
        System.out.println("Character: " + character + ", Font: " + fontFamily + ", Size: " + fontSize + ", Position: (" + row + ", " + column + ")");
    }
}
