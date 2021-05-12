package com.qa.penguins.service.penguin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.penguins.domain.Igloo;
import com.qa.penguins.repos.IglooRepository;

@Service
public class IglooService {

	private IglooRepository repo;

	public IglooService(IglooRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Igloo> getAll() {
		return this.repo.findAll();
	}

}
