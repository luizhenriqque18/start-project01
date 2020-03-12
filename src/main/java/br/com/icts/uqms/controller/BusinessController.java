package br.com.icts.uqms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.icts.uqms.domain.Business;
import br.com.icts.uqms.dto.BusinessDTO;
import br.com.icts.uqms.dto.form.BusinessFormDTO;
import br.com.icts.uqms.service.BusinessService;

@RestController
@RequestMapping("/register/business")
public class BusinessController {
	
	@Autowired
	private BusinessService service;
	
	@PostMapping()
    public ResponseEntity<BusinessDTO> create(@Valid @RequestBody BusinessFormDTO formDto ) {
		
		Business business =  service.create(formDto);
		
		return new ResponseEntity<>(new BusinessDTO(business), HttpStatus.OK);
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<BusinessDTO> update(@PathVariable Long id, @RequestBody BusinessFormDTO formDto) {
    	Business business =  service.update(id, formDto);
    	
    	if(business == null)
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	
    	return new ResponseEntity<>(new BusinessDTO(business), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    	
    	boolean result = service.delete(id);
    	
    	if(!result) {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public Page<BusinessDTO> find(@RequestParam(required = false) String search,
            @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) {
    	
    	Page<Business> business = service.find(search, pagination);
    	
    	return BusinessDTO.convert(business);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) { 
    	
    	Business business = service.findById(id);
    	
    	if(business == null)
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	
    	return new ResponseEntity<>(business, HttpStatus.OK);
    }
}
