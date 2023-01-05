package com.projetojefferson.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojefferson.dsclient.entities.Client;
import com.projetojefferson.dsclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findall(ListRequest listRequest){
		List<Client> list = repository.findAll();
	}
	
}
