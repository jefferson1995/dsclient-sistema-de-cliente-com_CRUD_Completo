package com.projetojefferson.dsclient.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojefferson.dsclient.entities.Client;
import com.projetojefferson.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findall(){

		Date data = new Date();
		List<Client> list = new ArrayList<>();
		
		list.add(new Client("jefferson"));
		
		return ResponseEntity.ok().body(list);
	}
	
}
