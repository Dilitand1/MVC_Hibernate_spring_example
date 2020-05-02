package service;

import model.dao.DaoImpl;
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

    public List getAllClients(){
        return dao.getAllClients();
    }
}
