package com.projetojefferson.dsclient.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	// Método para buscar todos clientes
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findall() throws ParseException {
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Método para buscar por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {

		ClientDTO dto = service.findByID(id);

		return ResponseEntity.ok().body(dto);

	}

	// Método para inserir novo cliente
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {

		dto = service.insert(dto);

		// Código com o endereço dos dados que estão sendo adicionado, nesse caso o id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

}
