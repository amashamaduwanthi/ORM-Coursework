package lk.ijse.DAO.DAOFactory;


import lk.ijse.DAO.DAOFactory.custom.DAOImpl.BookDAOImpl;
import lk.ijse.DAO.SuperDAO;

public class DAOFactory {

    public static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOType{
        BOOK,PERSON,USER,LIBRARY;
    }
    public SuperDAO getDAO(DAOType daoType) {
        switch (daoType) {
            case BOOK:
                return  new BookDAOImpl();

            default:
                return null;
        }

    }

}
