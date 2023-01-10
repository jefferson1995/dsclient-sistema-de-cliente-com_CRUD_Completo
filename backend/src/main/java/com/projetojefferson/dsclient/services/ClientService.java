package com.projetojefferson.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetojefferson.dsclient.dto.ClientDTO;
import com.projetojefferson.dsclient.entities.Client;
import com.projetojefferson.dsclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	// Método para buscar dados paginados
	@Transactional
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	// Método para buscar dados por ID
	@Transactional
	public ClientDTO findByID(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow();
		return new ClientDTO(entity);
	}

	// Método para salvar um novo cliente.
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto, entity); // método auxiliar
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

	//Método para atualizar client
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		Client entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

	private void copyDtoToEntity(ClientDTO dto, Client entity) { // Método auxiliar para adicionar um novo client ou
																	// fazer
																	// update
		// Método irá pegar todos os dados do DTO e inserir na entidade Product

		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
