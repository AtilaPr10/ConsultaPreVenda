package br.com.consultacep.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carregar {

	private String motorista;
	
	private ArrayList<PreVenda> prevendas;
	
	private Integer qtd_pedidos;
	
	private BigDecimal valor_total;
	
	
	

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public ArrayList<PreVenda> getPrevendas() {
		return prevendas;
	}

	public void setPrevendas(ArrayList<PreVenda> prevendas) {
		this.prevendas = prevendas;
	}

	public Integer getQtd_pedidos() {
		return qtd_pedidos;
	}

	public void setQtd_pedidos(Integer qtd_pedidos) {
		this.qtd_pedidos = qtd_pedidos;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	
	
	
	
	
	
	
}
