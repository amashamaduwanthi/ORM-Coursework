package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Entity.Book;

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
}
