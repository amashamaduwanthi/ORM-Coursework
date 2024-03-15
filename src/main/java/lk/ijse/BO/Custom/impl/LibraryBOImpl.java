package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.LibraryBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.LibraryDAO;
import lk.ijse.Dto.LibraryDTO;
import lk.ijse.Entity.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryBOImpl implements LibraryBO {
    LibraryDAO libraryDAO= (LibraryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LIBRARY);


    @Override
    public boolean saveLibrary(Library library) {
        return false;
    }

    @Override
    public boolean deleteLibrary(String id) {
        return false;
    }

    @Override
    public Library searchLibrary(String id) {
        return null;
    }

    @Override
    public boolean updateLibrary(Library library) {
        return false;
    }

    @Override
    public List<LibraryDTO> getAllBranches() {
        return null;
    }
}
