/**
 * 
 */
package com.acheron.mobilestore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.mobilestore.exceptions.IdNotFoundException;
import com.acheron.mobilestore.exceptions.NoDataException;
import com.acheron.mobilestore.model.Mobile;
import com.acheron.mobilestore.repository.IMobileRepository;

/**
 * @author BhargavRajJinka
 *
 */
@Service
public class MobileServiceImpl implements IMobileService{

	
	private IMobileRepository mobileRepository;
	@Autowired
	/**
	 * @param mobileRepository the mobileRepository to set
	 */
	public void setMobileRepository(IMobileRepository mobileRepository) {
		this.mobileRepository = mobileRepository;
	}

	@Override
	public List<Mobile> getAll() {
		
		List<Mobile> mobiles=new ArrayList<>();
		mobiles=mobileRepository.getAll();
		
		if(mobiles.isEmpty()) {
			throw new NoDataException("Database is Empty");
		}
		else {
			return mobiles;
		}
		
	}

	

	@Override
	public Mobile getById(String mobileId) {
		
		Mobile mobile=mobileRepository.getById(mobileId);
		
		if(mobile == null) {
			throw new IdNotFoundException("Requested MobileId "+mobileId+" Not Found");
		}
		else {
		
		return mobile;
		}
	}

}
