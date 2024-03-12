package lk.ijse.BoFactory;

import lk.ijse.BO.Custom.impl.BookBOImpl;
import lk.ijse.DAO.SuperDAO;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBOFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public void getBO() {

    }

    public enum BOType {
        BOOK,USER,PERSON,LIBRARY;

    }

    public SuperDAO getBO(BOType boType) {
        switch (boType) {
            case BOOK:
                return (SuperDAO) new BookBOImpl();
//            case USER:
//                return  new UserBOImpl();
//            case PERSON:
//                return new PersonBOImpl();
//            case LIBRARY:
//                return new LibraryBOImpl();
         default:
           return null;
        }

    }

}
