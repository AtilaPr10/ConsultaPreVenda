import java.io.IOException;

import br.com.consultacep.model.Endereco;
import br.com.consultacep.service.CepService;

public class TesteCep {

	public static void main(String[] args) {
		
		CepService cep = new CepService();
		
		Endereco endereco = new Endereco();
		
		try {
			
			endereco = cep.capturaCep("61658310");
			System.out.println(endereco);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
