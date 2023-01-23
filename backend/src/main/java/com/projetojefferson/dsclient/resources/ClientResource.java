package com.projetojefferson.dsclient.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetojefferson.dsclient.dto.ClientDTO;
import com.projetojefferson.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;

	// buscar todos clientes
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findallPaged(Pageable pageable) {

		Page<ClientDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	// buscar por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {

		ClientDTO dto = service.findByID(id);

		return ResponseEntity.ok().body(dto);

	}

	// inserir novo cliente

	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {

		dto = service.insert(dto);

		// Código com o endereço dos dados que estão sendo adicionado, nesse caso o id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	// atualizar cliente

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	// deletar cliente

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
