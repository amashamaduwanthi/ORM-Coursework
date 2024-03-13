package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.PersonBO;

import lk.ijse.DAO.DAOFactory.DAOFactory;
import lk.ijse.DAO.DAOFactory.custom.PersonDAO;
import lk.ijse.Entity.Person;

public class PersonBOImpl implements PersonBO {
    PersonDAO personDAO= (PersonDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PERSON);
    @Override
    public boolean savePerson(Person person) {
        Person persons = new Person(person.getUserName(), person.getEmail(), person.getPassword(), person.getRepassword(), person.getUserID());
        return personDAO.Save(persons);
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
        Person person1 = new Person(person.getUserName(),person.getPassword());
        return personDAO.update(person1);
    }

    @Override
    public boolean checkPassword(String username, String password) {
        Person person1 = new Person(username,password);
        return personDAO.update(person1);
    }
}
