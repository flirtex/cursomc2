package com.thiagovieira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagovieira.cursomc.domain.Pedido;
import com.thiagovieira.cursomc.repositories.PedidoRepository;
import com.thiagovieira.cursomc.services.exception.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Optional<Pedido> find(Integer id)  {
		Optional<Pedido> obj = repo.findById(id);
		if(obj == null) {
		throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
	
}
