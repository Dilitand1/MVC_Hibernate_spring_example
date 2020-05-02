package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
