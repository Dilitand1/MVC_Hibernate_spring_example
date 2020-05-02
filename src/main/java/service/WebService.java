package service;

import model.dao.DaoImpl;
import model.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

    @Autowired
    DaoImpl dao;

    public List getAllClientsSimulation(){
        return dao.getAllClientsSimulation();
    }

    public Person getClientById(int id){
        return dao.getClientById(id);
    }

    public List getAllClients(){
        return dao.getAllClients();
    }

    public List getClientsByName(String name){
        return dao.getClientsByName(name);
    }
}
