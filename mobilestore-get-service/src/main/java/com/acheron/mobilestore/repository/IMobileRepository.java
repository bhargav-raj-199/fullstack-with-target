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


	List<Mobile> getAll();
	Mobile getById(String mobileId);
	
	
}
