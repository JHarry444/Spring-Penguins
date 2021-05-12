package com.qa.penguins.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.penguins.rest.dtos.IglooDTO;
import com.qa.penguins.service.penguin.IglooService;

@RestController
@CrossOrigin
public class IglooController {

	private IglooService service;

	public IglooController(IglooService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getIgloos")
	public ResponseEntity<List<IglooDTO>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}
}
