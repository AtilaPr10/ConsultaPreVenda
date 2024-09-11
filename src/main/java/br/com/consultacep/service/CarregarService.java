package br.com.consultacep.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import br.com.consultacep.model.PreVenda;

public class CarregarService {
	
	BigDecimal valor;
	
	public BigDecimal somaValorTotal(ArrayList<PreVenda> prevendas) {
		valor = new BigDecimal(0);
		
		for(PreVenda p :prevendas  ) {
			
			valor =  valor.add(p.getValor_prevenda());
		
		}
		
		
		
		return valor;
		
		
	}

}
