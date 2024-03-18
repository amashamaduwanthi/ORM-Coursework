package lk.ijse.BO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.DTO.BranchDTO;

import java.sql.SQLException;
import java.util.List;

public interface LibraryBO extends SuperDAO {
    boolean saveBranch(BranchDTO dto) throws SQLException;
    List<BranchDTO> getAllBranches();
    BranchDTO search(String Id);
    boolean updateBranch(BranchDTO dto) throws SQLException;
    boolean deleteBranch(String Id) throws SQLException;
    String getBranchCount() throws SQLException;
}
