package br.com.consultacep.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import br.com.consultacep.model.Endereco;
import br.com.consultacep.util.Util;



public class CepService {
	
	
	private final String url_cep = "http://viacep.com.br/ws/";
	
	private final  String formato="/json/";
	
	static int codigoSucesso = 200;
	
	
	
	
	public Endereco capturaCep(String cep) throws IOException {
		
		
		String urlParaChamada = url_cep + cep + formato;
		
		System.out.println(urlParaChamada); 
		URL url = new URL(urlParaChamada);
		
		
		
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        
        if (conexao.getResponseCode() != codigoSucesso)
          throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

         BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
         Util util = new Util(); 
         String jsonEmString = util.converteJsonEmString(resposta);
         Gson gson = new Gson();
         Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
        
         return endereco;
        	
		
	}
	
	
	
}
