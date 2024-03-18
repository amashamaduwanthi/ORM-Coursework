package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.LibraryBO;
import lk.ijse.DAO.Custom.LibraryDAO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DTO.BranchDTO;
import lk.ijse.Entity.Library;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryBOImpl implements LibraryBO {
    LibraryDAO libraryDAO= (LibraryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LIBRARY);
    @Override
    public boolean saveBranch(BranchDTO dto) throws SQLException {
        return libraryDAO.Save(new Library(dto.getbId(), dto.getAddress(), dto.getbNumber(), dto.getStatus(), dto.getAdminId()));
    }
    @Override
    public List<BranchDTO> getAllBranches() {
        List<Library> branches = libraryDAO.getAll();
        List<BranchDTO> branchDtos = new ArrayList<>();
        for(Library branch : branches){
            branchDtos.add(new BranchDTO(branch.getbId(), branch.getAddress(), branch.getbNumber(), branch.getStatus(), branch.getAdminId()));
        }
        return branchDtos;
    }

    @Override
    public BranchDTO search(String Id) {
        Library library = libraryDAO.search(Id);
        BranchDTO branchDto = new BranchDTO(library.getbId(), library.getAddress(), library.getbNumber(), library.getStatus(), library.getAdminId());
        return branchDto;
    }

    @Override
    public boolean updateBranch(BranchDTO dto) throws SQLException {
        return libraryDAO.update(new Library(dto.getbId(), dto.getAddress(), dto.getbNumber(), dto.getStatus(), dto.getAdminId()));
    }

    @Override
    public boolean deleteBranch(String Id) throws SQLException {
        return libraryDAO.delete(Id);
    }

    @Override
    public String getBranchCount() throws SQLException {
        return libraryDAO.getCount();
    }

}
