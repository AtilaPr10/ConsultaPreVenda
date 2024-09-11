import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import  com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.consultacep.model.PreVenda;

public class TesteImpressao {
	
	public static PdfPTable criarCabecalho()
			throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 150f, 150f, 150f });
		PdfPCell celulaPrevenda = new PdfPCell(new Phrase("PRE VENDA"));
		celulaPrevenda.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell celulaNome = new PdfPCell(new Phrase("NOME"));
		celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaValor = new PdfPCell(new Phrase("VALOR"));
		celulaValor.setHorizontalAlignment(Element.ALIGN_CENTER);
        
		table.addCell(celulaPrevenda);
		table.addCell(celulaNome);
		table.addCell(celulaValor);
		
		return table;
	}
	
	public static void preencherDados(Document document, PdfPTable table,
			ArrayList<PreVenda> prevendas) throws DocumentException {
		if (document.isOpen()) {
			for (PreVenda prevenda : prevendas) {
				PdfPCell celula1 = new PdfPCell(new Phrase(prevenda.getCodigo_prevenda()));
				PdfPCell celula2 = new PdfPCell(new Phrase(prevenda.getNome_cliente()));
				PdfPCell celula3 = new PdfPCell(new Phrase(prevenda.getValor_prevenda().toString()));

				table.addCell(celula1);
				table.addCell(celula2);
				table.addCell(celula3);
			}

			document.add(table);
		}
	}

	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		PreVenda p1 = new PreVenda();
		PreVenda p2 = new PreVenda();
		PreVenda p3 = new PreVenda();
		p1.setCodigo_prevenda("01");
		p1.setNome_cliente("Joao");
		p1.setValor_prevenda(new BigDecimal(4.50));
		p2.setCodigo_prevenda("02");
		p2.setNome_cliente("Pedro");
		p2.setValor_prevenda(new BigDecimal(1.50));
		p3.setCodigo_prevenda("03");
		p3.setNome_cliente("Maria");
		p3.setValor_prevenda(new BigDecimal(10.50));
		
		
		ArrayList<PreVenda> prevendas = new ArrayList<PreVenda>();
		
		prevendas.add(p1);
		prevendas.add(p2);
		prevendas.add(p3);

		
		
		String RESULT =
				   "C:\\Users\\luisap\\eclipse-workspace\\ConsultaCepJson\\imp\\arqPDFexemplo2.pdf";
		 
		 Rectangle pagesize = new Rectangle(227, 842);
         Document document = new Document(pagesize, 1f, 1f, 1f, 1f);
		
	                                             
         try {
			PdfWriter.getInstance(document, new FileOutputStream(RESULT));
			document.open();
			
			document.add(new Paragraph("PRE VENDA"));
			document.add(new Paragraph(" "));
			
			                                        
			PdfPTable table = TesteImpressao.criarCabecalho();
			TesteImpressao.preencherDados(document, table , prevendas);
			document.add(new Paragraph("Joao"));
			LocalDate now = LocalDate.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String hojeFormatado = now.format(formatter);
			document.add(new Paragraph(hojeFormatado));
			
			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         finally {
        	 document.close();
			
		}
         
        
		

	}

}
