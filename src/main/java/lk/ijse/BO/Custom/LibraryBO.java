package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Dto.LibraryDTO;
import lk.ijse.Entity.Library;

import java.util.List;

public interface LibraryBO extends SuperDAO {



    boolean saveLibrary(Library library);

    boolean deleteLibrary(String id);

    Library searchLibrary(String id);

    boolean updateLibrary(Library library);

    List<LibraryDTO> getAllBranches();

}

