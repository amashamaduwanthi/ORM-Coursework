package lk.ijse.BOFactory;

import lk.ijse.BO.Custom.impl.*;
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
        BOOK,USER,PERSON,LIBRARY,BORROWBOOK;

    }

    public SuperDAO getBO(BOType boType) {
        switch (boType) {
            case BOOK:
                return  new BookBOImpl();
            case USER:
                return  new UserBOImpl();
            case PERSON:
                return new PersonBOImpl();
            case LIBRARY:
                return new LibraryBOImpl();
            case BORROWBOOK:
                return new BorrowBookBOImpl();
            default:
                return null;
        }
    }

}
