package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.BookBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.BookDAO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;

public class BookBOImpl  implements BookBO {

    BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BOOK);
    @Override
    public boolean saveBook(Book books) throws SQLException, ClassNotFoundException {
        Book book = new Book(books.getISBN(), books.getTitle(), books.getAuthor(), books.getGenre(), books.getStatus());
        return bookDAO.Save(book);
    }

    @Override
    public boolean deleteBook(String id) {
        return bookDAO.delete(id);
    }

    @Override
    public Book searchBook(String id) {
        return bookDAO.search(id);
    }

    @Override
    public boolean updateBook(Book books) {
        Book book = new Book(books.getISBN(), books.getTitle(), books.getAuthor(), books.getGenre(), books.getStatus());
        return bookDAO.update(book);
    }
}
