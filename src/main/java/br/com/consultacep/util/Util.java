package br.com.consultacep.util;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {

	public String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
	
	
	
	
	
	
}
