package com.acheron.mobilestore.util;

import com.acheron.mobilestore.exceptions.NoDataException;
import com.acheron.mobilestore.model.Mobile;
import com.arangodb.entity.BaseDocument;

public class Mapper {
	
	

	
	public static Mobile mobileMapper(BaseDocument object,String key) {
	
		if(object==null) {
			throw new NoDataException();
		}
		Mobile mobile=new Mobile();
		System.out.println(key);
		mobile.setMobileId(key) ;//(String)object.getAttribute("mobileId"));
		mobile.setTexture((String)object.getAttribute("texture"));
		mobile.setPrice((double)object.getAttribute("price"));
		mobile.setCategory((String)object.getAttribute("category"));
		mobile.setLength((double)object.getAttribute("length"));
		mobile.setWidth((double)object.getAttribute("width"));
		mobile.setMaterial((String)object.getAttribute("material"));
		mobile.setRating((double)object.getAttribute("rating"));
		mobile.setDescription((String)object.getAttribute("description"));
		mobile.setBrand((String)object.getAttribute("brand"));
		mobile.setModel((String)object.getAttribute("model"));
		mobile.setRam((int)object.getAttribute("ram"));
		mobile.setStorage((int)object.getAttribute("storage"));
		mobile.setOs((String)object.getAttribute("os"));
		mobile.setManufacturer((String)object.getAttribute("manufacturer"));
		mobile.setBattery((int)object.getAttribute("battery"));
		mobile.setWeight((double)object.getAttribute("weight"));
		
		mobile.setColor((String)object.getAttribute("color"));
		
		mobile.setDisplayTechnology((String)object.getAttribute("displayTechnology"));
		
		return mobile;
		
	}
}
