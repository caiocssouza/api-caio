package com.api.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.crm.model.Cliente;
import com.api.crm.repository.ClienteRepository;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar(){
		
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente clienteById(@PathVariable Long id) {
		return clienteRepository.findById(id).get();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		
	}
	
}
