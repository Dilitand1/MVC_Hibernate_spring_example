package service;

import model.dao.Dao;
import model.entities.Account;
import model.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

    @Autowired
    Dao dao;

    public WebService() {
    }

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

    public List getAllOperations(String acc){
        return dao.getAllOperations(acc);
    }


    public void addClient(String name) {
        dao.addClient(new Person(name));
    }


    public Account getAccountByNum(String acc) {
        return dao.getAccountByNum(acc);
    }


    public void deposit(String account, double sum, String from) {
        dao.deposit(dao.getAccountByNum(account), sum, from);
    }


    public void withdraw(String account, double sum, String to) throws Exception {
        dao.withdraw(dao.getAccountByNum(account), sum, to);
    }

    public void moneyTransfer(String from, String to, double sum) throws Exception {
        dao.moneyTransfer(from,to,sum);
    }


    public void dropClient(Person p) {

    }


    public void changeClient() {

    }


    public void moneyTransfer(Account from, Account to, double sum) {

    }

}
