package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.BorrowBookBO;
import lk.ijse.DAO.Custom.BookDAO;
import lk.ijse.DAO.Custom.BorrowBookDAO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DTO.BookDTO;
import lk.ijse.DTO.BorrowedBooksDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.BorrowBooks;
import lk.ijse.Entity.Person;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookBOImpl implements BorrowBookBO {
    BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BOOK);
    BorrowBookDAO borrowedBooksDao = (BorrowBookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.BORROWBOOKS);
    private static final int BORROWING_DAYS = 14;
    @Override
    public boolean placeBorrow(Person person, BookDTO bookdto, String id) throws SQLException {
        String title = bookdto.getTitle();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Book bookDto = bookDAO.getId(title);
            if (bookDto != null && "Available".equals(bookDto.getStatus())) {



                bookDto.setStatus("Unavailable");
                bookDAO.updateStatus(bookDto);

                BorrowBooks borrowedBooks = new BorrowBooks();
                borrowedBooks.setgId(id);
                borrowedBooks.setUser(person);

                borrowedBooks.setBook(bookDto);
                borrowedBooks.setBorrowedDate(LocalDateTime.now());

                LocalDateTime returnDate = LocalDateTime.now().plusDays(BORROWING_DAYS);
                borrowedBooks.setReturnDate(returnDate);

                session.save(borrowedBooks);
                transaction.commit();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<BorrowedBooksDto> getAllBorrowedBooks() {
        List<BorrowBooks> borrowedBooks = borrowedBooksDao.getAll();
        List<BorrowedBooksDto> borrowedBooksDtos = new ArrayList<>();
        for(BorrowBooks books : borrowedBooks){
            borrowedBooksDtos.add(new BorrowedBooksDto(books.getgId(),books.getBorrowedDate(),books.getReturnDate(),books.getBook(),books.getUser()));
        }
        return borrowedBooksDtos;
    }

}
