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


//miratelo en clase anda...
public class MongoDBConn {
	private final String URI = "mongodb://192.168.1.52:27017/";
	
	private MongoDatabase database;
	
	private List<Employee> employees=new ArrayList<Employee>();
	private ArrayList<Partida> partidak=new ArrayList<Partida>();

	
	
	
	public ArrayList<Partida> getPartidak() {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		try(MongoClient mongoClient = MongoClients.create(URI)){
			database = mongoClient.getDatabase("DisunityOfPepe3").withCodecRegistry(pojoCodecRegistry);

			MongoCollection<Partida> collection = database.getCollection("partidak",Partida.class);
			
		
			collection.find().into(partidak); //employee da null

		}catch(MongoException me) {
			System.out.println("Error getting partidak");
			System.err.println(me);
		}
		
		
		return partidak;
	}
	public List<Employee> getEmployees(){
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

		try(MongoClient mongoClient = MongoClients.create(URI)){
			database = mongoClient.getDatabase("DisunityOfPepe3").withCodecRegistry(pojoCodecRegistry);

			MongoCollection<Partida> collection = database.getCollection("partidak",Partida.class);
			
			collection.find().into(partidak);
			for(Partida partida : partidak){
				if(!employees.contains(partida.getEmployee())){
					employees.add(partida.getEmployee());
				}
			}

		}catch(MongoException me) {
			System.out.println("Error getting partidak");
			System.err.println(me);
		}



		return employees;  //es null
	}
	public MongoDBConn(){

	}
}
