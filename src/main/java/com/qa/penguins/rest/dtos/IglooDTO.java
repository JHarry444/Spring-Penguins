package com.qa.penguins.rest.dtos;

import java.util.Set;

public class IglooDTO {

	private Long id;

	private String name;

	private Set<PenguinDTO> penguins;

	public IglooDTO(Long id, String name, Set<PenguinDTO> penguins) {
		super();
		this.id = id;
		this.name = name;
		this.penguins = penguins;
	}

	public IglooDTO() {
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

	public Set<PenguinDTO> getPenguins() {
		return penguins;
	}

	public void setPenguins(Set<PenguinDTO> penguins) {
		this.penguins = penguins;
	}

}
