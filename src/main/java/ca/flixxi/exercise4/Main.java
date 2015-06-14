package ca.flixxi.exercise4;

import java.util.List;

/**
 * Created by Flyne on 14/06/2015.
 */
public class Main {
    public static void main(String[] args) {
        BookDaoJDBC bookDao = new BookDaoJDBC();
        Book b = new Book(3,"2013","John Grisham","Wiley",Category.NONFICION,217,38);
        bookDao.createBook(b);

       // bookDao.findAllBooks();
        List<Book> books = bookDao.findBooks(Category.NONFICION);
        for (Book book : books) {
            System.out.println(book.getAuthor());
        }
    }
}
