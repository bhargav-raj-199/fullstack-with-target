/**
 * 
 */
package com.acheron.mobilestore.repository;

import java.util.List;

import com.acheron.mobilestore.model.Mobile;
import com.arangodb.entity.BaseDocument;

/**
 * @author BhargavRajJinka
 *
 */

public interface IMobileRepository{

	void addMobile(Mobile mobile);

	void updateMobile(Mobile mobile);

	void deleteMobile(String id);


	
	
}
