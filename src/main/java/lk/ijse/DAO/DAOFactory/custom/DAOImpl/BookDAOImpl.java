package lk.ijse.DAO.DAOFactory.custom.DAOImpl;



import lk.ijse.DAO.DAOFactory.custom.BookDAO;
import lk.ijse.Entity.Book;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {


    @Override
    public boolean save(Book entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Book> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("from books");
            return (List<Book>) query.list();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public Book exists(String title) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("select b from books b where title = :title");
            query.setParameter("title",title);
            List<Book> result = query.getResultList();
            if(!result.isEmpty()){
                return result.get(0);
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Book entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("update books set author = :author, genre = :genre,status = :status where title = :title");
            query.setParameter("author",entity.getAuthor());
            query.setParameter("genre",entity.getGenre());
            query.setParameter("status",entity.getStatus());
            query.setParameter("title",entity.getTitle());

            int rowCount = query.executeUpdate();
            if(rowCount > 0){
                transaction.commit();
                return true;
            }else {
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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("from books  where title = :title");
            query.setParameter("title",title);
            Book book = (Book) query.uniqueResult();

            if(book != null){
                session.delete(book);
                transaction.commit();
                return true;
            }else {
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
    public String getCount() {
        return null;
    }

    @Override
    public Book search(String title) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Query query = session.createQuery("select b from books b where title = :title");
            query.setParameter("title",title);
            List<Book> result = query.getResultList();
            if(!result.isEmpty()){
                return result.get(0);
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getId(String title) {
        return null;
    }

    @Override
    public boolean updateStatus(Book entity) throws SQLException {
        return false;
    }
}
