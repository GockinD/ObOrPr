package skyshop.search;

import skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>(capacity);
    }

    public List<Searchable> search(String term) {
        List<Searchable> search = new ArrayList<>();
        for (Searchable product : searchables) {
            if (product.getSearchTerm() != null && (product.getSearchTerm()).contains(term)) {
                search.add(product);
            }
        }
        return search;
    }


    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Поисковой запрос пуст");
        }
        if (searchables == null) {
            throw new BestResultNotFound("Список пуст");
        }
        Searchable bestMatch = null;
        int maxCount = -1;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String str = searchable.getSearchTerm();
                int count = countSubstringOccurrences(str.toLowerCase(), search.toLowerCase());
                if (count > 0 && count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
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
