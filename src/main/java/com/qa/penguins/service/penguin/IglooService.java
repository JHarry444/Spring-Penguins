package com.qa.penguins.service.penguin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qa.penguins.domain.Igloo;
import com.qa.penguins.domain.Penguin;
import com.qa.penguins.repos.IglooRepository;
import com.qa.penguins.rest.dtos.IglooDTO;
import com.qa.penguins.rest.dtos.PenguinDTO;

@Service
public class IglooService {

	private IglooRepository repo;

	public IglooService(IglooRepository repo) {
		super();
		this.repo = repo;
	}

	private PenguinDTO mapToDTO(Penguin penguin) {
		PenguinDTO penguinDTO = new PenguinDTO();

		penguinDTO.setId(penguin.getId());
		penguinDTO.setAge(penguin.getAge());
		penguinDTO.setName(penguin.getName());
		penguinDTO.setNoOfChildren(penguin.getNoOfChildren());
		penguinDTO.setTuxedoSize(penguin.getTuxedoSize());

		return penguinDTO;
	}

	private IglooDTO mapToDTO(Igloo igloo) {
		IglooDTO dto = new IglooDTO();
		dto.setId(igloo.getId());
		dto.setName(igloo.getName());

		Set<PenguinDTO> penguinDtos = new HashSet<>();

		for (Penguin penguin : igloo.getPenguins()) {
			PenguinDTO penguinDTO = this.mapToDTO(penguin);
			penguinDtos.add(penguinDTO);
		}

		dto.setPenguins(penguinDtos);

		return dto;
	}

	public List<IglooDTO> getAll() {
		List<Igloo> found = this.repo.findAll();

		List<IglooDTO> dtos = new ArrayList<>();

		for (Igloo igloo : found) {
			IglooDTO dto = this.mapToDTO(igloo);
			dtos.add(dto);
		}

		return dtos;
	}

}
