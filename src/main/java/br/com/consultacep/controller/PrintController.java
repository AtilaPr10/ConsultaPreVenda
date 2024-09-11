package br.com.consultacep.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@ManagedBean(name="printController")
@SessionScoped
//@RequestScoped
@WebServlet("/pdf")
public class PrintController extends HttpServlet implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	


    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    	 Path path;
    	 ServletOutputStream output = null;
         File arquivo = new File("C:/Syspdv/imp/rel.pdf");
         path = arquivo.toPath();
   
	try {
			
			output = response.getOutputStream();
			Files.copy(path, output);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         finally {
		
            try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
		
     }
	
    
}
