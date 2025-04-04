package skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>(capacity);
    }

    public Set<String> search(String term) {
        return searchables.stream()
                .filter(obj -> obj.getSearchTerm().contains(term))
                .map(Searchable::getSearchTerm)
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SequenceNumberLetters())));
    }


    public Set<String> findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Поисковой запрос пуст");
        }
        if (searchables == null) {
            throw new BestResultNotFound("Список пуст");
        }
        Set<String> bestMatch = new TreeSet<>(new SequenceNumberLetters());
        int maxCount = -1;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String str = searchable.getSearchTerm();
                int count = countSubstringOccurrences(str.toLowerCase(), search.toLowerCase());
                if (count > 0 && count > maxCount) {
                    maxCount = count;
                    bestMatch.add(searchable.getSearchTerm());
                }
            }
        }
        if (maxCount == -1) {
            throw new BestResultNotFound("По запросу '" + search + "' совпадений не найдено");
        }
        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String search) {
        int count = 0;
        int index = 0;
        int indexSubString = str.indexOf(search, index);
        while (indexSubString != -1) {
            count++;
            index = indexSubString + search.length();
            indexSubString = str.indexOf(search, index);
        }
        return count;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
}
