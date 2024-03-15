package lk.ijse.DAO.DAOFactory.custom.DAOImpl;


import lk.ijse.DAO.DAOFactory.custom.LibraryDAO;
import lk.ijse.Entity.Library;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class LibraryDAOImpl implements LibraryDAO {


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
    public String getCount() {
        return null;
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

    @Override
    public boolean save(Library entity) throws SQLException {
        return false;
    }

    @Override
    public List<Library> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Library> list = session.createNativeQuery("SELECT * FROM Library", Library.class).list();
        transaction.commit();
        session.close();
        return list;

    }

    @Override
    public Library exists(String title) {
        return null;
    }

    @Override
    public boolean Save(Library librarys) {
        return false;
    }
}
