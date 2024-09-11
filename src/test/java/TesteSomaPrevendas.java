import java.math.BigDecimal;
import java.util.ArrayList;
import br.com.consultacep.model.PreVenda;
import br.com.consultacep.service.CarregarService;
import br.com.consultacep.service.PreVendaService;

public class TesteSomaPrevendas {

	public static void main(String[] args) {
		ArrayList<PreVenda> prevendas;
		BigDecimal valor = new BigDecimal(0);
		
		CarregarService c = new CarregarService();
		PreVendaService pvs = new PreVendaService();
		
		prevendas = pvs.listarPreVendas("15.08.2024", "15.08.2024");
		
		valor = valor.add(c.somaValorTotal(prevendas));
		
		System.out.println(c.somaValorTotal(prevendas));
		System.out.println(valor);
		
		
	}

}
