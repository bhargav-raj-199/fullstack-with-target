package com.acheron.mobilestore.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.acheron.mobilestore.configurations.ArangoDbConfiguration;
import com.acheron.mobilestore.exceptions.IdNotFoundException;
import com.acheron.mobilestore.model.Mobile;
import com.acheron.mobilestore.util.Mapper;
import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.DbName;
import com.arangodb.entity.BaseDocument;

@Repository
@PropertySource("classpath:application.properties")
public class MobileRepositoryImpl implements IMobileRepository{
	
	@Value("${db}")
	private String database;
	@Value("${collection}")
	private String table;

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

//	@SuppressWarnings("deprecation")


	@Override
	public List<Mobile> getAll() {
		List<Mobile> mobileList=new ArrayList<Mobile>();
		
		ArangoDatabase db = arangoDB.db(DbName.of(database));
		ArangoCollection collection=db.collection(table);

		String query = "FOR m IN mobile RETURN m";
		  Map<String, Object> bindVars = new HashMap<>();
		  ArangoCursor<BaseDocument> cursor = arangoDB.db(DbName.of(database)).query(query, bindVars, null, BaseDocument.class);
		  cursor.forEach(document -> {
		   
		    BaseDocument object=collection.getDocument(document.getKey(), BaseDocument.class);
		 
			Mobile mobile=Mapper.mobileMapper(object,document.getKey());

			mobileList.add(mobile);
		  });


		
		System.out.println(mobileList);
		return mobileList;
		
	}

	@Override
	public Mobile getById(String mobileId) throws IdNotFoundException {
		
		ArangoDatabase db = arangoDB.db(DbName.of(database));
		ArangoCollection collection=db.collection(table);
		
		Mobile mobile=new Mobile();
		BaseDocument object=collection.getDocument(mobileId, BaseDocument.class);
		
		
		
		mobile=Mapper.mobileMapper(object, mobileId);
		return mobile;
		
		
	}
	

}

