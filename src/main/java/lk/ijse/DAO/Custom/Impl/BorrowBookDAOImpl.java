package lk.ijse.DAO.Custom.Impl;


import lk.ijse.DAO.Custom.BorrowBookDAO;
import lk.ijse.Entity.BorrowBooks;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BorrowBookDAOImpl implements BorrowBookDAO {
    @Override
    public boolean Save(BorrowBooks entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<BorrowBooks> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("from borrowedBooks");
            return (List<BorrowBooks>) query.list();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public BorrowBooks exists(String title) {
        return null;
    }



    @Override
    public boolean update(BorrowBooks entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String title) throws SQLException {
        return false;
    }

    @Override
    public String getCount() {
        return null;
    }

    @Override
    public BorrowBooks search(String title) {
        return null;
    }

}
