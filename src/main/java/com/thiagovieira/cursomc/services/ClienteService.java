package com.thiagovieira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagovieira.cursomc.domain.Cliente;
import com.thiagovieira.cursomc.repositories.ClienteRepository;
import com.thiagovieira.cursomc.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> find(Integer id)  {
		Optional<Cliente> obj = repo.findById(id);
		if(obj == null) {
		throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
}
