package ca.flixxi.exercise4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyne on 14/06/2015.
 */
public class BookDaoJDBC implements BookDao {

    public Book findBook(long id) {
        Connection c = null;
        PreparedStatement pst = null;
        Book b = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kitsies", "root", "");
            pst = c.prepareStatement("select * from book where id = ?");
            pst.setInt(1,(int)id);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            b = new Book(rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    Category.findCategorybyLabel(rs.getString("category")),
                    rs.getInt("pages"),
                    rs.getInt("price") );

        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if(c != null)   {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }

    public Book findBook(String isbn) {
        Connection c = null;
        PreparedStatement pst = null;
        Book b = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kitsies", "root", "");
            pst = c.prepareStatement("select * from book where isbn = ?");
            pst.setString(1,isbn);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            b = new Book(rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    Category.findCategorybyLabel(rs.getString("category")),
                    rs.getInt("pages"),
                    rs.getInt("price") );

        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if(c != null)   {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }


    public List<Book> findBooks(Category category) {
        Connection c = null;
        PreparedStatement pst = null;
        List<Book> b = new ArrayList<Book>();
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kitsies", "root", "");
            pst = c.prepareStatement("select * from book where category = ?");
            pst.setObject(1, category.getLabel());
            pst.execute();
            ResultSet rs = pst.getResultSet();
            while(rs.next()) {
                b.add(new Book(rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        Category.findCategorybyLabel(rs.getString("category")),
                        rs.getInt("pages"),
                        rs.getInt("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if(c != null)   {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }

    public List<Book> findAllBooks() {
        Connection c = null;
        Statement st = null;
        List<Book> b = new ArrayList<Book>();
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kitsies", "root", "");
            st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from book");
            while(rs.next()) {
                b.add(new Book(rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        Category.findCategorybyLabel(rs.getString("category")),
                        rs.getInt("pages"),
                        rs.getInt("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if(c != null)   {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }

    public void createBook(Book b) {
        Connection c = null;
        PreparedStatement pst = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kitsies", "root", "");
            pst = c.prepareStatement("insert into book (id,isbn, author, publisher, category, pages, price) values (?,?,?,?,?,?,?)");
            pst.setInt(1,b.getId());
            pst.setString(2,b.getIsbn());
            pst.setString(3,b.getAuthor());
            pst.setString(4,b.getPublisher());
            pst.setObject(5,b.getCategory().getLabel());
            pst.setInt(6,b.getPages());
            pst.setInt(7,b.getPrice());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if(c != null)   {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void updateBook(Book b) {

    }

    public void deleteBook(Book b) {

    }

    @Override
    public void deleteAllBooks() {
        Connection c = null;

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsies", "root", "");
            Statement st = c.createStatement();
            st.executeUpdate("truncate book");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally   {
            if (c != null)  {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
