package com.projetojefferson.dsclient.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Client implements Serializable {


	private static final long serialVersionUID = 1L;
	private Long id;
	private String name, cpf;
	private Double income;
	private Date birthDate;
	private Integer children;
	
	//Construtor sem argumentos.
	public Client(String name) {	
		this.name = name;
	}

	//Construtor com argumentos
	public Client(Long id, String name, String cpf, Double income, Date birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
