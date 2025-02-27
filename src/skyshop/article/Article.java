package skyshop.article;

import skyshop.search.Searchable;

public class Article implements Searchable {
    String articleTitle;
    String textArticle;

    public Article(String articleTitle, String textArticle) {
        this.articleTitle = articleTitle;
        this.textArticle = textArticle;
    }


    @Override
    public String toString() {
        return "Название статьи: " + articleTitle + '\'' +
                "Текст статьи: " + textArticle;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }


}
