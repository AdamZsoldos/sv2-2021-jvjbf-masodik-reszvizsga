package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        validateWord(word);
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> uniqueWords = new ArrayList<>();
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            } else {
                return true;
            }
        }
        return false;
    }

    private void validateWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        } else if (!word.toLowerCase().equals(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
    }
}
