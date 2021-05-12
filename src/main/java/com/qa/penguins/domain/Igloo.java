package com.qa.penguins.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Igloo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "igloo")
	private Set<Penguin> penguins;

	public Igloo(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Igloo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Penguin> getPenguins() {
		return penguins;
	}

	public void setPenguins(Set<Penguin> penguins) {
		this.penguins = penguins;
	}

}
