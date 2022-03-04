package com.qa.cat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cat.domain.Cat;
import com.qa.cat.service.CatService;

@RestController
public class CatController {

	private CatService service;

	@Autowired
	public CatController(CatService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Cat> createCat(@RequestBody Cat t) {
		Cat created = this.service.create(t);
		ResponseEntity<Cat> response = new ResponseEntity<Cat>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Cat>> getAllCats() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping("/get/{id}")
	public Cat getCatId(@PathVariable Integer id) {
		return this.service.getId(id);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Cat> replaceCat(@PathVariable Integer id, @RequestBody Cat t) {
		Cat body = this.service.replace(id, t);
		ResponseEntity<Cat> response = new ResponseEntity<Cat>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeCat(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}