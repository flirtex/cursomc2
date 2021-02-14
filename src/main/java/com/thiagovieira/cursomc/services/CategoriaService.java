package com.thiagovieira.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.thiagovieira.cursomc.domain.Categoria;
import com.thiagovieira.cursomc.repositories.CategoriaRepository;
import com.thiagovieira.cursomc.services.exception.DataIntegriyException;
import com.thiagovieira.cursomc.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	// Service do Categoria Find
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	// Service do Categoria Insert
	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}
	
	//Service do Categoria Update
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	// Service do Categoria Delete
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegriyException("Não é possível Excluir uma Categoria que possui produtos.");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
}
