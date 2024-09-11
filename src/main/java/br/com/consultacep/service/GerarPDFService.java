package br.com.consultacep.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.consultacep.model.PreVenda;

public class GerarPDFService {
	
	
	public  PdfPTable criarCabecalho()
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
	
	public void preencherDados(Document document, PdfPTable table,
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

	
	
	
	public void gerarPDF(ArrayList<PreVenda> prevendas,String nome_entregador, String valor_total) {
		
		
		//String RESULT =
				//   "C:\\Users\\luisap\\eclipse-workspace\\ConsultaCepJson\\imp\\arqPDFexemplo2.pdf";
		
		String RESULT =
				   "C:\\Syspdv\\imp\\rel.pdf";
		 
		 Rectangle pagesize = new Rectangle(216, 720);
         Document document = new Document(pagesize, 1f, 1f, 1f, 1f);
      try {
			PdfWriter.getInstance(document, new FileOutputStream(RESULT));
             document.open();
			
			document.add(new Paragraph("PRE VENDA"));
			document.add(new Paragraph(" "));
			
			                                        
			PdfPTable table = criarCabecalho();
			preencherDados(document, table , prevendas);
			System.out.println("entregador "+nome_entregador);
			document.add(new Paragraph(nome_entregador));
			LocalDate now = LocalDate.now(); 
			document.add(new Paragraph("Valor Total R$: "+valor_total));
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
