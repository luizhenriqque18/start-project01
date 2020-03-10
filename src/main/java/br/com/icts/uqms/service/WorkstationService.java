package br.com.icts.uqms.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.icts.uqms.domain.Workstation;
import br.com.icts.uqms.dto.WorkstationDTO;
import br.com.icts.uqms.dto.form.WorkstationFormDTO;
import br.com.icts.uqms.repository.WorkstationRepository;

@Service
public class WorkstationService {

    @Autowired
    private WorkstationRepository workstationRepository;

	public Workstation create(@Valid WorkstationFormDTO form) {
        Workstation workstation = form.convert();

        return workstationRepository.save(workstation);
	}

	public Workstation update(Long id, @Valid WorkstationFormDTO form) {
        Optional<Workstation> optional =  workstationRepository.findById(id);

        if(optional.isPresent()) {
            return workstationRepository.save(form.convert(id));

        } else {
            return null;
        }
	}

	public Boolean delete(Long id) {
        Optional<Workstation> optional = workstationRepository.findById(id);

        if(optional.isPresent()){
            workstationRepository.deleteById(id);
            return true;
        }
        return false;
	}

	public ResponseEntity<WorkstationDTO> findById(Long id) {
        Optional<Workstation> workstation = workstationRepository.findById(id);

        if(workstation.isPresent()) {
            return ResponseEntity.ok(new WorkstationDTO(workstation.get()));
        }

        return ResponseEntity.notFound().build();
	}

	public Page<Workstation> find(String search, Pageable pagination) {
        Page<Workstation> workstations = null;
        if(search == null) {
            workstations = workstationRepository.findAll(pagination);
        }

        return workstations;
	}

    // this class connect with repository
}