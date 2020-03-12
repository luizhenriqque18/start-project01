package br.com.icts.uqms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icts.uqms.domain.Business;

public interface BusinessRepository extends JpaRepository<Business, Long> {
	
	Page<Business> findByNameContaining(String name, Pageable pagination);
}
