package com.qa.cat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.cat.domain.Cat;
import com.qa.cat.repo.CatRepo;

@Service
public class CatService implements ServiceIF<Cat> {

	private CatRepo repo;

	@Autowired
	public CatService(CatRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Cat create(Cat t) {
		Cat created = this.repo.save(t);
		return created;

	}

	@Override
	public List<Cat> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Cat getId(Integer id) {
		Optional<Cat> found = this.repo.findById(id);
		return found.get();

	}

	@Override
	public Cat replace(Integer id, Cat t) {
		Cat existing = this.repo.findById(id).get();
		existing.setName(t.getName());
		existing.setBreed(t.getBreed());
		existing.setAge(t.getAge());
		Cat updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);

	}

}
