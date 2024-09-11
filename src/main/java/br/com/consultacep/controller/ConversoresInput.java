package br.com.consultacep.controller;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value="convertCep")
public class ConversoresInput implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) throws ConverterException {
		if(valor != null || valor != "") {
			valor = valor.toString().replaceAll("[- /.]", "");
			valor = valor.toString().replaceAll("[-()]", "");
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object valor) throws ConverterException {
		
		return valor.toString();
		
	}

}
