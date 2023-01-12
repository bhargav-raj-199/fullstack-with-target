/**
 * 
 */
package com.acheron.mobilestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.mobilestore.model.Mobile;
import com.acheron.mobilestore.repository.IMobileRepository;
import com.arangodb.entity.BaseDocument;

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
	public void addMobile(Mobile mobile) {
		 mobileRepository.addMobile(mobile);
	}

	@Override
	public void updateMobile(Mobile mobile) {
		mobileRepository.updateMobile(mobile);		
	}


	@Override
	public void deleteMobile(String mobileId) {
		mobileRepository.deleteMobile(mobileId);
	}

	
}
