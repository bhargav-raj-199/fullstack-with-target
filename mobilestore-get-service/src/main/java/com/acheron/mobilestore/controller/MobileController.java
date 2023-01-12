package com.acheron.mobilestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.mobilestore.model.Mobile;
import com.acheron.mobilestore.service.IMobileService;
import com.arangodb.entity.BaseDocument;

@RestController
@RequestMapping("mobile-get-api")
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
	
	@PreAuthorize("hasAnyRole('MANAGER', 'EDITOR' ,'MEMBER')")
	@GetMapping("/mobiles")
	ResponseEntity<List<Mobile>> getAll(){
		
		System.out.println(mobileService.getAll());
		return ResponseEntity.ok().body(mobileService.getAll());
	}



	
	
	@PreAuthorize("hasAnyRole('MANAGER','EDITOR','MEMBER')")
	@GetMapping("/mobiles/{mobileId}")
	ResponseEntity<Mobile> getById(@PathVariable("mobileId") String mobileId){
		
		return ResponseEntity.ok().body(mobileService.getById(mobileId));
	}
	
}
