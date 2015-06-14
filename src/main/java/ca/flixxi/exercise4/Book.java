package ca.flixxi.exercise4;

/**
 * Created by Flyne on 14/06/2015.
 */
public class Book {
    private Integer id;
    private String isbn;
    private String author;
    private String publisher;
    private Category category;
    private int pages;
    private int price;

    public Book(Integer id, String isbn, String author, String publisher, Category category, int pages, int price) {
        this.id = id;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.pages = pages;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
