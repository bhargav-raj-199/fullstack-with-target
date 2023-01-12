package com.acheron.mobilestore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acheron.mobilestore.configurations.ArangoDbConfiguration;
import com.acheron.mobilestore.model.Mobile;
import com.acheron.mobilestore.util.Mapper;
import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.DbName;
import com.arangodb.entity.BaseDocument;

@Repository
public class MobileRepositoryImpl implements IMobileRepository{

	private ArangoDbConfiguration configuration;
	@Autowired
	private ArangoDB arangoDB;
	@Autowired
	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(ArangoDbConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public void addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		BaseDocument object=Mapper.dbMapper(mobile);
		ArangoDatabase db = arangoDB.db(DbName.of("mobiledb"));
		ArangoCollection collection=db.collection("mobile");
		
		collection.insertDocument(object);
		
	}

	@Override
	public void updateMobile(Mobile mobile) {
		
		BaseDocument object=Mapper.dbMapper(mobile);
		ArangoDatabase db = arangoDB.db(DbName.of("mobiledb"));
		ArangoCollection collection=db.collection("mobile");
		//collection.insertDocument(object);
		collection.replaceDocument(mobile.getMobileId(), mobile); 
	}

	@Override
	public void deleteMobile(String id) {
		ArangoDatabase db = arangoDB.db(DbName.of("mobiledb"));
		ArangoCollection collection=db.collection("mobile");
		collection.deleteDocument(id);
	}
	

}

