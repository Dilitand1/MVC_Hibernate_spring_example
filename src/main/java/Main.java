import config.ConfigClass;
import model.dao.Dao;
import model.dao.DaoImpl;
import model.entities.Account;
import model.entities.Accountop;
import model.entities.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.WebService;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        //Dao dao = context.getBean("daoImpl", Dao.class);
        WebService webService = context.getBean(WebService.class);

        List list = webService.getAllOperations("40702810001");
        System.out.println(list);

        //Accountop accountop = new Accountop(new Date(),1000d);
        //Person person = dao.getClientById(1);
        //System.out.println(person);

//        Account account = dao.getAccountByNum("40702810003");
//        System.out.println(account);
//        dao.deposit(account,1000.2d, "Наличные");
//        dao.withdraw(account,10.1d, "Наличные");

        /*try {
            dao.moneyTransfer("40702810001", "40702810002", 10D);
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
    }

    public static void addOp(){


    }
}
