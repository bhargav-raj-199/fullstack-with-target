package com.acheron.mobilestore.util;

import java.time.LocalDate;

import com.acheron.mobilestore.model.Mobile;
import com.arangodb.entity.BaseDocument;

public class Mapper {
	
public static BaseDocument dbMapper(Mobile mobile) {
		
		BaseDocument object=new BaseDocument();
//		object.setKey(mobile.getMobileId());
//		object.addAttribute("mobileId", mobile.getMobileId());
		object.addAttribute("texture", mobile.getTexture());
		object.addAttribute("price", mobile.getPrice());
		object.addAttribute("category", mobile.getCategory());
		object.addAttribute("length", mobile.getLength());
		object.addAttribute("width", mobile.getWidth());
		object.addAttribute("material", mobile.getMaterial());
		object.addAttribute("rating", mobile.getRating());
		object.addAttribute("description", mobile.getDescription());
		object.addAttribute("brand", mobile.getBrand());
		object.addAttribute("model", mobile.getModel());
		object.addAttribute("ram", mobile.getRam());
		object.addAttribute("storage", mobile.getStorage());
		object.addAttribute("os", mobile.getOs());
		object.addAttribute("manufacturer", mobile.getManufacturer());
		object.addAttribute("battery", mobile.getBattery());
		object.addAttribute("weight", mobile.getWeight());
		object.addAttribute("color", mobile.getColor());
		object.addAttribute("displayTechnology", mobile.getDisplayTechnology());
		
		
		return object;
		
		
	}


}
