package skyshop.search;

import skyshop.product.Product;

import java.util.Objects;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public Searchable[] search(String term) {
        Searchable[] search = new Searchable[5];
        int resultIndex = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && (searchables[i].getSearchTerm()).contains(term)) {
                search[resultIndex] = searchables[i];
                resultIndex++;
            }
            if (resultIndex == 5) {
                break;
            }
        }return search;
    }

    public void add(Searchable searchable) {
        searchables[size] = searchable;
        size++;
    }
}
