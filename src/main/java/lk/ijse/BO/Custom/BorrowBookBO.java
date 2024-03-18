package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.DTO.BookDTO;
import lk.ijse.DTO.BorrowedBooksDto;
import lk.ijse.Entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface BorrowBookBO extends SuperDAO {
    boolean placeBorrow(Person user, BookDTO book, String Id) throws SQLException;
    List<BorrowedBooksDto> getAllBorrowedBooks();
}
