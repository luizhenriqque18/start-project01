package br.com.icts.uqms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icts.uqms.domain.Workstation;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

}