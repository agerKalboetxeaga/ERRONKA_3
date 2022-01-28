package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;



import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * This class manages the connection with MongoDB
 * 
 * @author kalboetxeaga.ager
 *
 */
public class MongoDBConn {
	
	private final String URI = "mongodb://localhost:27017/";//MongoDB connection string
	private MongoDatabase database;
	
	//Lists to store the objects retrieved from the Database
	private List<Employee> employees=new ArrayList<Employee>();
	private ArrayList<Partida> partidak=new ArrayList<Partida>();

	
	
	/**
	 * Method to get a List of Partidak from MongoDb
	 * @return Returns a List of all partidak in the database
	 */
	public ArrayList<Partida> getPartidak() {
		//As we are working with Models we must specify it.
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		//The connection:
		try(MongoClient mongoClient = MongoClients.create(URI)){
			database = mongoClient.getDatabase("partidak").withCodecRegistry(pojoCodecRegistry);

			MongoCollection<Partida> collection = database.getCollection("puntuazioak",Partida.class);
			
			//Querying the list
			collection.find().into(partidak); //employee da null

		}catch(MongoException me) {
			System.out.println("Error getting partidak");
			System.err.println(me);
		}
		
		return partidak;
	}
	/**
	 * Method to get all employees from the list
	 * @return
	 */
	public List<Employee> getEmployees(){
		//Calling getPartidak method to fill partidak List			
		getPartidak();
		for(Partida partida : partidak){
			if(!employees.contains(partida.getEmployee())){
				employees.add(partida.getEmployee());
			}
		}
		return employees;  //es null
	}
	
	/**
	 * Simple constructor for MongoDBConn
	 */
	public MongoDBConn(){

	}
}
