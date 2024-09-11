package br.com.consultacep.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.consultacep.model.Carregar;
import br.com.consultacep.model.PreVenda;
import br.com.consultacep.service.CarregarService;
import br.com.consultacep.service.GerarPDFService;
import br.com.consultacep.service.PreVendaService;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.servlet.http.HttpServletResponse;


@ManagedBean(name = "preVenda")
@ViewScoped
//@SessionScoped
//@RequestScoped
public class PreVendaController implements Serializable {
	
  private String data1;
	
  private String data2;
	
  public PreVendaService pvs = new PreVendaService();
  
  public CarregarService cs = new CarregarService();
  
  public Carregar carregar = new Carregar();
	
  private ArrayList<PreVenda> prevendas ;
	
  private ArrayList<PreVenda> prevendas_selecionadas ;
  
  private PreVenda prevenda_selecionada;
  
  private BigDecimal valor_total;
  
  private String str_valor_total;
  
  private String nome_entregador;
  
  private InputStream inputStream = null;
  
 
  
  public GerarPDFService pdf = new GerarPDFService() ;
  
	
        public List<PreVenda> buscaPrevendas()     { 
		     prevendas = new ArrayList<PreVenda>();
		     prevendas = pvs.listarPreVendas(data1, data2);
	         return prevendas ;
		
		
     	}
        
        
        public void carregarPreVendas(ActionEvent event) {
        	
        	valor_total = new BigDecimal(0);
        	System.out.println(prevendas_selecionadas);
        	valor_total = valor_total.add(cs.somaValorTotal(this.prevendas_selecionadas));
        	str_valor_total = valor_total.toString();
        	System.out.println(valor_total);
        	System.out.println(str_valor_total);
        	System.out.println(nome_entregador);
        	pdf.gerarPDF(prevendas_selecionadas,nome_entregador,str_valor_total);
        	
        	
        	
        	
        }
        
        
        
       
        
        
    
        
       
       public void onRowSelect(SelectEvent<PreVenda> event) {
    	   prevendas_selecionadas = new ArrayList<PreVenda>();
    	   prevenda_selecionada = (PreVenda)event.getObject();
    	   prevendas_selecionadas.add(prevenda_selecionada);
    	   
       }
        
       
		public String getNome_entregador() {
		   return nome_entregador;
	}


	   public void setNome_entregador(String nome_entregador) {
		    this.nome_entregador = nome_entregador;
	}


		public String getStr_valor_total() {
		    return str_valor_total;
	}


	   public void setStr_valor_total(String str_valor_total) {
		    this.str_valor_total = str_valor_total;
	}   


		public void imprimir(ActionEvent event) {
        	
        	System.out.println(prevendas_selecionadas);
        }
        
  
		public Carregar getCarregar() {
			return carregar;
		}


		public void setCarregar(Carregar carregar) {
			this.carregar = carregar;
		}


		public BigDecimal getValor_total() {
			return valor_total;
		}


		public void setValor_total(BigDecimal valor_total) {
			this.valor_total = valor_total;
		}


		public PreVenda getPrevenda_selecionada() {
	          return prevenda_selecionada;
         } 



        public void setPrevenda_selecionada(PreVenda prevenda_selecionada) {
	            this.prevenda_selecionada = prevenda_selecionada;
         }

		public ArrayList<PreVenda> getPrevendas_selecionadas() {
	            return prevendas_selecionadas;
          } 
   

          public void setPrevendas_selecionadas(ArrayList<PreVenda> prevendas_selecionadas) {
	           this.prevendas_selecionadas = prevendas_selecionadas;
           }


		public String getData1() {
			return data1;
		}


		public void setData1(String data1) {
			this.data1 = data1;
		}


		public String getData2() {
			return data2;
		}


		public void setData2(String data2) {
			this.data2 = data2;
		}


		public ArrayList<PreVenda> getPrevendas() {
			return prevendas;
		}


		public void setPrevendas(ArrayList<PreVenda> prevendas) {
			this.prevendas = prevendas;
		}
	
	
	

}
