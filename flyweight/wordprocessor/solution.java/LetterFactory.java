
import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    private static final Map<Character, ILetter> characterCache = new HashMap<>();

    public static ILetter getLetter(char characterValue) {
            return characterCache.computeIfAbsent(characterValue, Letter::new);
    }

    public static int getTotalCharactersCreated() {
        return characterCache.size();
    }
}
