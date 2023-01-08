package com.projetojefferson.dsclient.resources;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojefferson.dsclient.dto.ClientDTO;
import com.projetojefferson.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findall() throws ParseException{
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
