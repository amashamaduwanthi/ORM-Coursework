package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.LibraryBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.LibraryDAO;
import lk.ijse.Dto.LibraryDTO;
import lk.ijse.Entity.Library;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryBOImpl implements LibraryBO {
    LibraryDAO libraryDAO= (LibraryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LIBRARY);


    @Override
    public List<LibraryDTO> getAllBranches() {
        List<Library> branches = libraryDAO.getAll();
        List<LibraryDTO> branchDtos = new ArrayList<>();
        for(Library branch : branches){
            branchDtos.add(new LibraryDTO(branch.getbId(), branch.getAddress(), branch.getbNumber(), branch.getStatus(), branch.getAdminId()));
        }
        return branchDtos;
    }

    @Override
    public boolean saveBranch(LibraryDTO dto) throws SQLException {
        return libraryDAO.save(new Library(dto.getbId(), dto.getAddress(), dto.getbNumber(), dto.getStatus(), dto.getAdminId()));
    }

    @Override
    public boolean updateBranch(LibraryDTO dto) throws SQLException {
        return libraryDAO.update(new Library(dto.getbId(), dto.getAddress(), dto.getbNumber(), dto.getStatus(), dto.getAdminId()));
    }

    @Override
    public LibraryDTO search(String id) {
        Library branch = libraryDAO.search(id);
        LibraryDTO branchDto = new LibraryDTO(branch.getbId(), branch.getAddress(), branch.getbNumber(), branch.getStatus(), branch.getAdminId());
        return  branchDto;
    }
}
