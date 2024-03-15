package lk.ijse.DAO.DAOFactory.custom.DAOImpl;


import lk.ijse.DAO.DAOFactory.custom.LibraryDAO;
import lk.ijse.Entity.Library;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class LibraryDAOImpl implements LibraryDAO {


    @Override
    public boolean save(Library entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Library> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("from branches ");
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

    @Override
    public boolean update(Library entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("update branches set bNumber = :bNumber, status = :status where bId = :bId");
            query.setParameter("bNumber",entity.getbNumber());
            query.setParameter("status",entity.getStatus());
            query.setParameter("bId",entity.getbId());

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
    public boolean delete(String title) throws SQLException {
        return false;
    }

    @Override
    public String getCount() {
        return null;
    }

    @Override
    public Library search(String Id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("select b from branches b where bId = :bId");
            query.setParameter("bId",Id);
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
}
