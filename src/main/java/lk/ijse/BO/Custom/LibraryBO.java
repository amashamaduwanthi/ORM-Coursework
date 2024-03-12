package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Entity.Library;

public interface LibraryBO extends SuperDAO {



    boolean saveLibrary(Library library);

    boolean deleteLibrary(String id);

    Library searchLibrary(String id);

    boolean updateLibrary(Library library);
}

