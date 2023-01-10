package com.projetojefferson.dsclient.services;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	// Método para buscar dados por ID
	@Transactional
	public ClientDTO findByID(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("id not found"));
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
		try {
			Client entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("id not found");
		}
		
	}
	

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("id not found: " + id);
		}
		
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

}
