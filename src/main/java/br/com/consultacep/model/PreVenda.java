package br.com.consultacep.model;

import java.math.BigDecimal;



public class PreVenda {
	
   private String codigo_prevenda;
	
	
	private String nome_cliente;
	
	
	
	private BigDecimal valor_prevenda;



	public String getCodigo_prevenda() {
		return codigo_prevenda;
	}



	public void setCodigo_prevenda(String codigo_prevenda) {
		this.codigo_prevenda = codigo_prevenda;
	}



	public String getNome_cliente() {
		return nome_cliente;
	}



	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}



	public BigDecimal getValor_prevenda() {
		return valor_prevenda;
	}



	public void setValor_prevenda(BigDecimal valor_prevenda) {
		this.valor_prevenda = valor_prevenda;
	}



	@Override
	public String toString() {
		return "Prevenda [codigo_prevenda=" + codigo_prevenda + ", nome_cliente=" + nome_cliente + ", valor_prevenda="
				+ valor_prevenda + "]";
	}
	
	
	
	
	

}
