package br.com.icts.uqms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icts.uqms.domain.ProductionLine;

public interface ProductionLineRepository extends JpaRepository<ProductionLine, Long> {

}