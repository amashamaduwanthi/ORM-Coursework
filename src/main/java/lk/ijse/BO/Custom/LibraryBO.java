package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Dto.LibraryDTO;

import java.sql.SQLException;
import java.util.List;

public interface LibraryBO extends SuperDAO {





    List<LibraryDTO> getAllBranches();

    boolean saveBranch(LibraryDTO dto) throws SQLException;

    boolean updateBranch(LibraryDTO branchDto) throws SQLException;

    LibraryDTO search(String id);
}

