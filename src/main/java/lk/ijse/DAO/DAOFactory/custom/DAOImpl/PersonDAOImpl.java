package lk.ijse.DAO.DAOFactory.custom.DAOImpl;


import lk.ijse.DAO.DAOFactory.custom.PersonDAO;
import lk.ijse.Entity.Person;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public boolean Save(Person person) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(Person person) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Person search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        transaction.commit();
        session.close();
        return person;
    }


    @Override
    public String generateUserID() {
        return null;
    }
}