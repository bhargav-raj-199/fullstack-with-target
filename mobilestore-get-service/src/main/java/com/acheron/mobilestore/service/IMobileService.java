package com.acheron.mobilestore.service;

import java.util.List;

import com.acheron.mobilestore.model.Mobile;
import com.arangodb.entity.BaseDocument;

public interface IMobileService {

	List<Mobile> getAll();
	Mobile getById(String mobileId);

}
