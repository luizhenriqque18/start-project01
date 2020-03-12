package br.com.icts.uqms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.icts.uqms.domain.Business;
import br.com.icts.uqms.dto.form.BusinessFormDTO;
import br.com.icts.uqms.repository.BusinessRepository;

@Service
public class BusinessService {
	
	@Autowired
	BusinessRepository repository;
	
	public Business create(BusinessFormDTO formDto) {
		
		return repository.save(formDto.convert());
	}
	
	public Business update(Long id, BusinessFormDTO formDto) {
		
		Optional<Business> business = repository.findById(id);
		
		if(business.isPresent())
			return repository.save(formDto.convert(id));
		
		return null;
	}
	
	public boolean delete(Long id) {
	
		Optional<Business> business = repository.findById(id);
		
		if(business.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	public Business findById(Long id) {
        Optional<Business> business = repository.findById(id);

        if(business.isPresent()) {
            return business.get();
        }

        return null;
	}
	
	public Page<Business> find(String search, Pageable pagination) {
        
		Page<Business> business = null;
        
        if(search == null) {
        	business = repository.findAll(pagination);
        }else{
        	business = repository.findByNameContaining(search, pagination);
        }

        return business;
	}
	
	
}
