package model.dao;

import model.entities.Person;

import java.util.ArrayList;
import java.util.List;

public interface Dao {

    public List<Person> getClientsByName(String name);
    public Person getClientById(int id);
    public List getAllClients();
    public void addClient(Object o);
    public void dropClient(int id);
    public void changeClient();

    public void deposit(Object o);
    public void withdraw(Object o);
    public void moneyTransfer(Object o1, Object o2);

    public List getAllClientsSimulation();
}
