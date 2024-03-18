package lk.ijse.DAO.Custom.Impl;


import lk.ijse.DAO.Custom.LibraryDAO;
import lk.ijse.Entity.Library;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

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

        try{
            Query query = session.createQuery("update library set bNumber = :bNumber, status = :status where bId = :bId");
            query.setParameter("bNumber",library.getbNumber());
            query.setParameter("status",library.getStatus());
            query.setParameter("bId",library.getbId());

            int rowCount = query.executeUpdate();
            if(rowCount > 0 ){
                transaction.commit();
                return true;
            }else{
                transaction.rollback();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    @Override
    public boolean delete(String id) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("from library where bId = :bId");
            query.setParameter("bId",id);
           Library branch = (Library) query.uniqueResult();

            if(branch != null){
                session.delete(branch);
                transaction.commit();
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }

    }
    @Override
    public String getCount() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Long count = (Long) session.createQuery("select count (*) from library ").getSingleResult();
            transaction.commit();
            return String.valueOf(count);
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public Library search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("select b from library b where bId = :bId");
            query.setParameter("bId",id);
            List<Library> result = query.getResultList();
            if(!result.isEmpty()){
                return result.get(0);
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean del(String Id) throws SQLException {
        return false;
    }
    @Override
    public List<Library> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("from library ");
            return (List<Library>) query.list();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public Library exists(String title) {
        return null;
    }
}
