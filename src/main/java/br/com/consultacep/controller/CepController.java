package br.com.consultacep.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import br.com.consultacep.model.Endereco;
import br.com.consultacep.service.CepService;
import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "cepBean")
public class CepController {
	
	public CepService cep_service = new CepService();
	
	private String cep;

	private List<Endereco> enderecos;
	
	
	public  List<Endereco>  retornaEndereco() {
		
		enderecos = new ArrayList<Endereco>();
		
		try {
			enderecos.add(cep_service.capturaCep(cep));
			System.out.println(enderecos.get(0));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 return enderecos;
		  
	}
	
	
	
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}




	public List<Endereco> getEnderecos() {
		return enderecos;
	}




	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	
	
	
	
	
	

}
