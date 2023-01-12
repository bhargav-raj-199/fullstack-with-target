package com.acheron.mobilestore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arangodb.ArangoDB;
import com.arangodb.mapping.ArangoJack;

@Configuration

public class ArangoDbConfiguration {

	@Bean("arangoDB")
	public ArangoDB prepareArangoDB(){
		return  new ArangoDB.Builder().host("localhost", 8529).user("root")
	  .serializer(new ArangoJack())
	  .build();
		
//		return  new ArangoDB.Builder().host("localhost", 8529).user("raj").password("root").build();
	 // retrun arangoDB;
	}
    
	
    //ArangoDB arangodb=arango();

}
