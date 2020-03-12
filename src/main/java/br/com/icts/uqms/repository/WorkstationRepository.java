package br.com.icts.uqms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icts.uqms.domain.Workstation;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    Page<Workstation> findByNameContaining(String name, Pageable pagination);

}