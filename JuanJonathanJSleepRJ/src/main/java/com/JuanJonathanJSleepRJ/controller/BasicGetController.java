package com.JuanJonathanJSleepRJ.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.JuanJonathanJSleepRJ.dbjson.*;
import com.JuanJonathanJSleepRJ.*;

@RestController

/**
 * Basic Get Controller Interface -
 * Contains abstract methods for basic GET requests.
 * @author juanjonathan67
 * @version 1.0.0
 */
@RequestMapping()
public interface BasicGetController <T extends Serializable>{
	/**
	 * Abstract method to implement a getter for {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} of an Object
	 * @return {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} of the Object specified
	 */
	abstract JsonTable<T> getJsonTable();
	
	/**
	 * Method to get object by Id
	 * @param id Id to be searched
	 * @return Object with matching Id
	 */
	@GetMapping("/{id}")
	public default T getById(
		@PathVariable int id
	){
		Predicate<T> predicate = object -> object.id == id;
		return Algorithm.find(getJsonTable(), predicate);
	}
	
	/**
	 * Method to paginate {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable}
	 * @param page Page number
	 * @param pageSize Page size
	 * @return List of Objects after paginate
	 */
	@GetMapping("/page")
	public default List<T> getPage(
		@RequestParam int page, 
		@RequestParam int pageSize
	){
		return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
	}
}
