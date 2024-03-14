package lk.ijse.DAO.DAOFactory.custom.DAOImpl;


import lk.ijse.Entity.Book;
import lk.ijse.Entity.Person;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class PersonDAOImpl implements Book.PersonDAO {
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
    public boolean checkPassword(String username, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery<String> nativeQuery = session.createNativeQuery("SELECT password FROM Person WHERE username = :username");
        nativeQuery.setParameter("username",username);

        String pass = nativeQuery.uniqueResult();

        transaction.commit();
        session.close();

        if (password.equalsIgnoreCase(pass)) {
            return true;
        }else {
            return false;
        }

    }

    @Override
    public String generateUserID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<String> nativeQuery = session.createNativeQuery("SELECT userID FROM Person ORDER BY userID DESC LIMIT 1");
        String id = nativeQuery.uniqueResult();
        transaction.commit();
        session.close();

        if (id != null) {
            String[] strings = id.split("U0");
            int newID = Integer.parseInt(strings[1]);
            newID++;
            String ID = String.valueOf(newID);
            int length = ID.length();
            if (length < 2) {
                return "U00" + newID;
            } else {
                if (length < 3) {
                    return "U0" + newID;
                } else {
                    return "U" + newID;
                }
            }
        } else {
            return "U001";
        }

    }
}