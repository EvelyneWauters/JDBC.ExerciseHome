package ca.flixxi.exercise4;

import java.util.List;

/**
 * Created by Flyne on 14/06/2015.
 */
public interface BookDao {

    public Book findBook(long id);
    public Book findBook(String isbn);
    public List<Book> findBooks(Category category);
    public List<Book> findAllBooks();
    public void createBook(Book b);
    public void updateBook(Book b);
    public void deleteBook(Book b);
    public void deleteAllBooks();
}
