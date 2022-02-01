package com.example.restservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * This class is used as the controller of the web service.
 * This version is mainly for debuging.
 * @author kalboetxeaga.ager
 *
 */
@RestController
public class Controller {
	//Lists to store our models from mongo
    private List<Partida> partidak=new ArrayList<Partida>();		
    private List<Employee> employees=new ArrayList<Employee>();
    private MongoDBConn mongoConnection;

   /**
    * Request method (for all partidak)
    * @return Returns a list of partdidak object
    */
    @GetMapping("/partidak")
    public List<Partida> partida(){
    	//Connecting to mongo and displaying the list
        mongoConnection = new MongoDBConn();
        partidak = mongoConnection.getPartidak();
        //Print out an object to ensure it is working 
        System.out.println(partidak.get(0).getEmployee().getWorkEmail());	
        
        return partidak;
    }
    
    /**
     * Request method (for employees) *Is never used*
     * @return Returns a list of employee object
     */
    @GetMapping("/employees")
    public List<Employee> employee(){
    	//Connecting to mongo and displaying the list
        mongoConnection = new MongoDBConn();
        employees = mongoConnection.getEmployees();
    	
        return employees;
    }
    
    /**
     * Request Method to display all partidak which were played by the given employee
     * @param name Name of the employee
     * @return Returns a list of partidak object
     */
    @GetMapping("/partida")
    public List<Partida> partidaIzenaz(@RequestParam(value = "name",defaultValue = "Ager")String name){
    	//Connecting to mongo and finding the matches to display
    	mongoConnection = new MongoDBConn();
        partidak = mongoConnection.getPartidak();
        List<Partida> partidaIzenez = new ArrayList<Partida>();
        for(Partida p : partidak) {
        	if(p.getEmployee().getName().equals(name)) {
        		partidaIzenez.add(p);
        	}
        }
        return partidaIzenez;
    }
    @GetMapping("/hof")
    public List<Partida> hallOfFame(){
    	 mongoConnection = new MongoDBConn();
         partidak = mongoConnection.gethof();

         return partidak;
    	
    }
    @GetMapping("/hos")
    public List<Partida> hallOfShame(){
    	 mongoConnection = new MongoDBConn();
         partidak = mongoConnection.gethos();

         return partidak;
    	
    }
    
    
}
