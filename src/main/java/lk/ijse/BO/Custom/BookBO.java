package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.DTO.BookDTO;

import java.sql.SQLException;
import java.util.List;

public interface BookBO extends SuperDAO {
    boolean saveBook(BookDTO dto) throws SQLException;

    List<BookDTO> getAllBooks();

    BookDTO existsBook(String title);

    boolean updateBook(BookDTO dto) throws SQLException;

    boolean deleteBook(String title) throws SQLException;

    String getBookCount() throws SQLException;

    BookDTO searchBook(String title);

    BookDTO getBookId(String title);

    boolean updateBookStatus(BookDTO dto) throws SQLException;

    public BookDTO getBookWithBorrowedBooks(String bookId);
}
