package com.formacionbdi.springboot.app.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.service.ItemService;
import com.formacionbdi.springboot.app.item.models.Item;

import java.util.List;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}

}
