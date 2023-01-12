package com.acheron.mobilestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.mobilestore.model.Mobile;
import com.acheron.mobilestore.service.IMobileService;

@RestController
@RequestMapping("mobile-crud-api")
@CrossOrigin("http://localhost:1234")

public class MobileController {

	private IMobileService mobileService;
	
	@Autowired
	/**
	 * @param mobileservice the mobileservice to set
	 */
	public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}
	@PreAuthorize("hasAnyRole('MANAGER')")
	@PostMapping("/mobiles")
	ResponseEntity<Void> addMobile(@RequestBody Mobile mobile){
		mobileService.addMobile(mobile);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PreAuthorize("hasAnyRole('MANAGER','EDITOR')")
	@PutMapping("/mobiles")
	ResponseEntity<Void> updateMobile(@RequestBody Mobile mobile){
		mobileService.updateMobile(mobile);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PreAuthorize("hasAnyRole('MANAGER')")
	
	@DeleteMapping("/mobiles/{mobileId}")
	ResponseEntity<Void> deleteMobile(@PathVariable("mobileId") String mobileId){
		mobileService.deleteMobile(mobileId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
