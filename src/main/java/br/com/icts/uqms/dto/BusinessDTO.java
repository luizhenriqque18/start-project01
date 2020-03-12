package br.com.icts.uqms.dto;

import org.springframework.data.domain.Page;

import br.com.icts.uqms.domain.Business;

public class BusinessDTO {
	
	private Long id;
	
	private String name;
	
	public BusinessDTO(Business business) {
		this.id = business.getId();
		this.name = business.getName();
	}
	
	public BusinessDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Page<BusinessDTO> convert(Page<Business> business) {
        return business.map(BusinessDTO::new);
	}
}
