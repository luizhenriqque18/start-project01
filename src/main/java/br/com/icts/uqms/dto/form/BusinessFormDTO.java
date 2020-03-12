package br.com.icts.uqms.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.icts.uqms.domain.Business;

public class BusinessFormDTO {
		
	@NotNull
	@NotBlank
	private String name;
	
	public String getName() {
		return name;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Business convert() {
		return new Business(name);
	}
	
	public Business convert(Long id) {
		return new Business(id, name);
	}
}
