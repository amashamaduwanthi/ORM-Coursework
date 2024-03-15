package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.BookBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.BookDAO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBOImpl  implements BookBO {

    BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BOOK);


    @Override
    public boolean saveBook(BookDTO dto) throws SQLException {
        return bookDAO.save(new Book(dto.getbId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getStatus()));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookDAO.getAll();
        List<BookDTO> bookDtos = new ArrayList<>();
        for(Book book : books){
            bookDtos.add(new BookDTO(book.getbId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getStatus()));
        }
        return bookDtos;
    }

    @Override
    public BookDTO existsBook(String title) {
        Book book = bookDAO.exists(title);
        BookDTO bookDto = new BookDTO(book.getAuthor(), book.getGenre(), book.getStatus());
        return bookDto;
    }

    @Override
    public boolean updateBook(BookDTO dto) throws SQLException {
        return bookDAO.update(new Book(dto.getbId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getStatus()));
    }

    @Override
    public boolean deleteBook(String title) throws SQLException {
        return bookDAO.delete(title);
    }

    @Override
    public String getBookCount() throws SQLException {
        return bookDAO.getCount();
    }

    @Override
    public BookDTO searchBook(String title) {
        Book book = bookDAO.search(title);
        BookDTO bookDto = new BookDTO(book.getbId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getStatus());
        return bookDto;
    }
}
