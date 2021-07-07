package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;

	@Transactional
	public CityDTO insert(CityDTO dto) {
		City city = new City();
		city.setName(dto.getName());
		city = repository.save(city);
		
		return new CityDTO(city);
		
	}

	
	public List<CityDTO> findAll() {
		List<City> lista = repository.findAll(Sort.by("name"));
		return lista.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}

}
