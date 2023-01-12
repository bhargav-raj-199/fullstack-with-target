package com.acheron.mobilestore.service;

import java.util.List;

import com.acheron.mobilestore.model.Mobile;
import com.arangodb.entity.BaseDocument;

public interface IMobileService {

	void addMobile(Mobile mobile);

	void updateMobile(Mobile mobile);

	void deleteMobile(String id);

}
