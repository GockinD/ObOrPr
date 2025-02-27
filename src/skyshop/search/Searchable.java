package skyshop.search;

import skyshop.product.Product;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation(){
        return getSearchTerm() + " - " + getContentType();
    }
}
