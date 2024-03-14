package lk.ijse.DAO.DAOFactory.custom.DAOImpl;



import lk.ijse.DAO.DAOFactory.custom.BookDAO;
import lk.ijse.Entity.Book;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean Save(Book book) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public boolean update(Book book) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Book book = new Book(id);
        session.delete(book);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public Book search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.get(Book.class, id);
        transaction.commit();
        session.close();

        return book;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
