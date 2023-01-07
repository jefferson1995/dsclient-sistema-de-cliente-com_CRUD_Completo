package com.projetojefferson.dsclient.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojefferson.dsclient.entities.Client;
import com.projetojefferson.dsclient.resources.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findall() throws ParseException{

		List<Client> list = service.findAll();
		
	
		
		
		return ResponseEntity.ok().body(list);
	}
	
}
