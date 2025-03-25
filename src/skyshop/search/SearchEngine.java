package skyshop.search;

import skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>(capacity);
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> search = new TreeMap<>();
        for (Searchable product : searchables) {
            if (product != null && product.getSearchTerm() != null) {
                if (product.getSearchTerm().contains(term)) {
                    search.put(product.getSearchTerm(), product);
                }
            }
        }
        return search;
    }


    public Map<String, Searchable> findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Поисковой запрос пуст");
        }
        if (searchables == null) {
            throw new BestResultNotFound("Список пуст");
        }
        Map<String, Searchable> bestMatch = new TreeMap<>();
        int maxCount = -1;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String str = searchable.getSearchTerm();
                int count = countSubstringOccurrences(str.toLowerCase(), search.toLowerCase());
                if (count > 0 && count > maxCount) {
                    maxCount = count;
                    bestMatch.put(searchable.getSearchTerm(), searchable);
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
