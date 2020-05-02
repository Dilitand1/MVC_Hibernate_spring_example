package model.dao;

import model.entities.Person;

import java.util.ArrayList;
import java.util.List;

public interface Dao {

    public void getClient(int id);
    public List getAllClients();
    public void addClient(Object o);
    public void dropClient(int id);
    public void changeClient();

    public List getAllClientsSimulation();
}
