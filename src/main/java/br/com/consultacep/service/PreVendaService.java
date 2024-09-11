package br.com.consultacep.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.consultacep.infra.Conexao;
import br.com.consultacep.model.PreVenda;

public class PreVendaService {
	
	
Conexao conexao;
	
	Connection con;
	
	ArrayList<PreVenda> prevendas;
	
	PreVenda prevenda;
	
	public ArrayList<PreVenda> listarPreVendas(String data_inicial, String data_final) {
		
		
		// data_inicial="15.08.2024";
		 //data_final="15.08.2024";
		 
		String consulta_sql = "select p.PRVNUM , p.PRVCLIDES , p.PRVVLR from prevenda p WHERE ( p.PRVDATEMI Between cast("+"'"+data_inicial+"'"+" as date) And cast("+"'"+data_final+"'"+" as date)AND  p.PRVSTAATU IS NULL AND p.PRVTIPATD = 'T' )";
		
		Conexao conexao = new Conexao();
		prevenda = new PreVenda();
		con = conexao.conecta();
		prevendas = new ArrayList<PreVenda>();
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet result = stmt.executeQuery(consulta_sql);
			
		    while (result.next()) {
		    	
		    	
		    	prevenda = new PreVenda();
				prevenda.setCodigo_prevenda(result.getString("PRVNUM"));
				prevenda.setNome_cliente(result.getString("PRVCLIDES"));
				prevenda.setValor_prevenda(result.getBigDecimal("PRVVLR"));
				prevendas.add(prevenda);
				
			} result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
			try {
				
				stmt.close();
				con.close();
				conexao.fechaConexao();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Não foi possível fechar banco: "+e.getMessage());			}
			
			
		}
	    
	    return prevendas;
		
		
		
		
	}
	

}
