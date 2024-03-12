package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.LibraryBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.LibraryDAO;
import lk.ijse.Entity.Library;

public class LibraryBOImpl implements LibraryBO {
    LibraryDAO libraryDAO= (LibraryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LIBRARY);

    @Override
    public boolean saveLibrary(Library library) {
        Library librarys = new Library(library.getId(), library.getName(), library.getAddress(), library.getTel());
        return libraryDAO.Save(librarys);
    }

    @Override
    public boolean deleteLibrary(String id) {
        return libraryDAO.delete(id);
    }

    @Override
    public Library searchLibrary(String id) {
        return libraryDAO.search(id);
    }

    @Override
    public boolean updateLibrary(Library library) {
        Library librarys = new Library(library.getId(), library.getName(), library.getAddress(), library.getTel());
        return libraryDAO.update(librarys);
    }
}
