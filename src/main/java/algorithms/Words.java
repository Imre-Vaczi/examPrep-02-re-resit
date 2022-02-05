package algorithms;

import java.util.*;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWords(String ... wordsToAdd) {
        for (String line : wordsToAdd) {
            words.add(line);
        }
    }

    public List<String> findWordsOccursOnes() {
        return(selectUniqueWords(mappingWords()));
    }

    private List<String> selectUniqueWords(Map<String, Integer> mapping) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapping.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private Map<String, Integer> mappingWords() {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (String line : words) {
            if (temp.containsKey(line)) {
                temp.put(line, temp.get(line)+1);
            } else {
                temp.put(line, 1);
            }
        }
        return temp;
    }

    public List<String> getWords() {
        return List.copyOf(words);
    }
}
