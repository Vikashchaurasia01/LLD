public class WordProcessorSimulation {
    public static void main(String[] args) {
        System.out.println("Hello World! This is a sample document for the Flyweight pattern demonstration.");
        
        ILetter obj1 = LetterFactory.getLetter('H');
        obj1.display(0, 0);

        ILetter obj2 = LetterFactory.getLetter('e');
        obj2.display(0, 1);

        ILetter obj3 = LetterFactory.getLetter('l');
        obj3.display(0, 2);

        ILetter obj4 = LetterFactory.getLetter('l');
        obj4.display(0, 3);

        ILetter obj5 = LetterFactory.getLetter('o');
        obj5.display(0, 4);

        ILetter obj6 = LetterFactory.getLetter(' ');
        obj6.display(0, 5);

        ILetter obj7 = LetterFactory.getLetter('W');
        obj7.display(0, 6);

        ILetter obj8 = LetterFactory.getLetter('o');
        obj8.display(0, 7);

        ILetter obj9 = LetterFactory.getLetter('r');
        obj9.display(0, 8);

        ILetter obj10 = LetterFactory.getLetter('l');
        obj10.display(0, 9);

        ILetter obj11 = LetterFactory.getLetter('d');
        obj11.display(0, 10);

        // Total unique characters created: 8 - because we are using the same object for 'l' and 'o' which are already created and stored in the cache.
        System.out.println("Total unique characters created: " + LetterFactory.getTotalCharactersCreated());
    }
}
