package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.WebService;

import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    WebService webService;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        return "index2";
    }

    @RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public @ResponseBody List getAllClients(){
        return webService.getAllClients();
    }

    @RequestMapping(value = "/getclient/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Person getAllClientById(@PathVariable int id){
        return webService.getClientById(id);
    }

    @RequestMapping(value = "/getclients/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List getAllClientsByName(@PathVariable String name){
        return webService.getClientsByName(name);
    }

    @RequestMapping(path = "/account/{accountNumber}")
    public @ResponseBody List getAllOperations(@PathVariable String accountNumber){
        return webService.getAllOperations(accountNumber);
    }

    //http://localhost:8080/JavaRebootMVC20200430_MVC_war_exploded/deposit?account=40702810001&summa=111
    @RequestMapping(path = "/deposit")
    public @ResponseBody String deposit(@RequestParam("account") String account , @RequestParam("sum") double summa){
        webService.deposit(account,summa,"Наличные");
        return "ok";
    };

    @RequestMapping(path = "/withdraw")
    public @ResponseBody String withdraw(@RequestParam("account") String account , @RequestParam("sum") double summa) throws Exception {
        webService.withdraw(account,summa,"Наличные");
        return "ok";
    };
    @RequestMapping(path = "/transfer")
    public @ResponseBody String transfer(@RequestParam("accountFrom") String from,@RequestParam("accountTo") String to, @RequestParam("sum") double sum) throws Exception {
        webService.moneyTransfer(from,to,sum);
        return "ok";
    };

    @RequestMapping(value = "/getAllClientsSimulate", method = RequestMethod.GET)
    public @ResponseBody
    List getAllClientsSimulation(){
        return webService.getAllClientsSimulation();
    }

    @RequestMapping(value = "/getAllClientsSimulate2", method = RequestMethod.GET)
    public @ResponseBody
    String getAllClientsSimulation2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(webService.getAllClientsSimulation());
    }

    @RequestMapping(value = "/getAllClientsSimulate3", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity getAllClientsSimulation3() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (ResponseEntity) webService.getAllClients();
    }

    //http://localhost:8080/JavaRebootMVC20200430_MVC_war_exploded/getAllClientsSimulate
    //http://localhost:8080/JavaRebootMVC20200430_MVC_war_exploded/getAllClientsSimulate2
    //http://localhost:8080/JavaRebootMVC20200430_MVC_war_exploded/getAllClients
}
