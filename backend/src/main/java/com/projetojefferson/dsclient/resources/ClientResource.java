package com.projetojefferson.dsclient.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.projetojefferson.dsclient.entities.Client;

@RestController
@RequestMapping(value = "/clients")

public class ClientResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@GetMapping
	public ResponseEntity<List<Client>> findall() throws ParseException{

		List<Client> list = new ArrayList<>();
		
		String name = "Jefferon";
		String cpf = "42988244898";
		Double income = 22.5;
		Date birthDate = sdf.parse("02/01/1995");
		Integer children = 10;
		
		list.add(new Client(1L, name, cpf, income, birthDate, children));
		
		
		return ResponseEntity.ok().body(list);
	}
	
}
