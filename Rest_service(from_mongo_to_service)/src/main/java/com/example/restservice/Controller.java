package com.example.restservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private List<Partida> partidak=new ArrayList<Partida>();
    private List<Employee> employees=new ArrayList<Employee>();
    private Partida[] partidak2;
    private MongoDBConn mongoConnection;

    /*
    * Request method (for all partidak)
    * */
    @GetMapping("/partidak")
    public List<Partida> partida(/*aki meter los parametros...*/){
        mongoConnection = new MongoDBConn();
        partidak = mongoConnection.getPartidak();
    	//Employee employee1 = new Employee("1","ager","123","20570","berrgara","agag@ag","2423432");
    	//Employee employee2 = new Employee("2","Ramon","231","20570","berrgara","agag@ag","2423432");
        Date date = new Date();
        //partidak.add(new Partida("5556","5543","543,76",date,employee1));
        //partidak.add(new Partida("4432","5543","543,76",date,employee2));
        
        
        return partidak;
    }
    
    @GetMapping("/employees")
    public List<Employee> employee(/*aki meter los parametros...*/){
        mongoConnection = new MongoDBConn();
        employees = mongoConnection.getEmployees();
    	//Employee employee1 = new Employee("1","ager","123","20570","berrgara","agag@ag","2423432");
    	//Employee employee2 = new Employee("2","Ramon","231","20570","berrgara","agag@ag","2423432");
        Date date = new Date();
        //partidak.add(new Partida("5556","5543","543,76",date,employee1));
        //partidak.add(new Partida("4432","5543","543,76",date,employee2));
        
        
        return employees;
    }
    
}
