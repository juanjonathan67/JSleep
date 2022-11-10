package com.JuanJonathanJSleepRJ.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.JuanJonathanJSleepRJ.dbjson.*;
import com.JuanJonathanJSleepRJ.*;

@RestController

@RequestMapping()
public interface BasicGetController <T extends Serializable>{
	abstract JsonTable<T> getJsonTable();
	
	@GetMapping("/{id}")
	public default T getById(
		@PathVariable int id
	){
		Predicate<T> predicate = object -> object.id == id;
		return Algorithm.find(getJsonTable(), predicate);
	}
	
	@GetMapping("/page")
	public default List<T> getPage(
		@RequestParam int page, 
		@RequestParam int pageSize
	){
		return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
	}
}
