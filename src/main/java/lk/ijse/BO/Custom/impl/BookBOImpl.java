package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.BookBO;
import lk.ijse.DAO.Custom.BookDAO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DTO.BookDTO;
import lk.ijse.Entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BOOK);
    @Override
    public boolean saveBook(BookDTO dto) throws SQLException {
        return bookDAO.Save(new Book(dto.getbId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getStatus()));
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
        return null;
    }

//    @Override
//    public BookDTO existsBook(String title) {
//        Book book = bookDAO.exist(title);
//        BookDTO bookDto = new BookDTO(book.getAuthor(), book.getGenre(), book.getStatus());
//        return bookDto;
//    }

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

    @Override
    public BookDTO getBookId(String title) {
        Book book = bookDAO.getId(title);
        BookDTO bookDto = new BookDTO(book.getbId());
        return bookDto;
    }

    @Override
    public boolean updateBookStatus(BookDTO dto) throws SQLException {
        return bookDAO.updateStatus(new Book(dto.getStatus()));
    }

    @Override
    public BookDTO getBookWithBorrowedBooks(String bookId) {
        return null;
    }


    private BookDTO convertToBookDto(Book book) {
        if(book == null){
            return null;
        }

        BookDTO bookDto = new BookDTO();
        bookDto.setbId(book.getbId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setGenre(book.getGenre());
        bookDto.setStatus(book.getStatus());

        return bookDto;
    }
}
