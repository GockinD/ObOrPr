package skyshop.article;

import skyshop.search.Searchable;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleTitle);
    }
}
