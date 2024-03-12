package lk.ijse.DAO.DAOFactory.custom.DAOImpl;


import lk.ijse.DAO.DAOFactory.custom.LibraryDAO;
import lk.ijse.Entity.Library;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LibraryDAOImpl implements LibraryDAO {
    @Override
    public boolean Save(Library library) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(library);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(Library library) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(library);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Library library = new Library(id);
        session.delete(library);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public Library search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Library library = session.get(Library.class, id);
        transaction.commit();
        session.close();

        return library;
    }
}
