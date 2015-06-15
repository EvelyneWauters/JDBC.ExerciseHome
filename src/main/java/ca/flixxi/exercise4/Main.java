package ca.flixxi.exercise4;

import java.util.List;

/**
 * Created by Flyne on 14/06/2015.
 */
public class Main {
    public static void main(String[] args) {
        BookDaoJDBC bookDao = new BookDaoJDBC();
        bookDao.deleteAllBooks();

        Book a = new Book(2,"1951","Harper Lee","Lilac",Category.DRAMA,305,15);
        Book b = new Book(1,"2013","John Grisham","Wiley",Category.NONFICTION,217,38);

        bookDao.createBook(a);
        bookDao.createBook(b);

        List<Book> allBooks = bookDao.findAllBooks();
        for (Book allBook : allBooks) {
            System.out.println(allBook.getAuthor());
        }


        List<Book> books = bookDao.findBooks(Category.NONFICTION);
        for (Book book : books) {
            System.out.println("book nonfiction = "+ book.getAuthor());
        }



    }
}
