package br.com.consultacep.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
public Connection con = null;
	
	
	public Conexao(){
		try{
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			con = 
				DriverManager.getConnection(
				"jdbc:firebirdsql:localhost/3050:C:/Syspdv/syspdv_srv.fdb",
				"SYSDBA",
				"masterkey");
		
		}catch (Exception e){
			System.out.println("Não foi possível conectar so banco: "+e.getMessage());
		    e.printStackTrace();
		}
   }  
	
	
	
	public Connection conecta() {
		
		return con;
	}
	

	public void fechaConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 

}
