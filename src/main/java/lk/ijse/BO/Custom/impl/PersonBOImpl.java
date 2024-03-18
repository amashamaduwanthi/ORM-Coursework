package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.DAO.Custom.PersonDAO;
import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DTO.PersonDTO;
import lk.ijse.Entity.Person;

import java.sql.SQLException;

public class PersonBOImpl implements PersonBO {
    PersonDAO personDAO= (PersonDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PERSON);
    @Override
    public boolean savePerson(Person person) throws SQLException {
        Person persons = new Person(person.getuId(),person.getUserName(),person.getPassword(),person.getConfirmPassword());
        return personDAO.Save(persons);
    }

    @Override
    public boolean checkPassword(String username, String password) {
        return personDAO.checkPassword(username, password);
    }

    @Override
    public String generateClientId() {
        return personDAO.generateUserID();
    }

    @Override
    public Person searchPerson(String searchId) {
        return personDAO.search(searchId);
    }

    @Override
    public boolean changePassword(Person person) {
        Person person1 = new Person(person.getuId(),person.getUserName(),person.getPassword(),person.getConfirmPassword());
        try {
            return personDAO.update(person1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PersonDTO getUserId(String username) throws SQLException {
        String user = personDAO.get(username);
        if(user != null){
            PersonDTO userDto = new PersonDTO(user);
            return userDto;
        }else {
            return null;
        }
    }
}
