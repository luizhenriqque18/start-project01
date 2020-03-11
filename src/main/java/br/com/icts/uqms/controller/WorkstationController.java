package br.com.icts.uqms.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.icts.uqms.domain.Workstation;
import br.com.icts.uqms.dto.WorkstationDTO;
import br.com.icts.uqms.dto.form.WorkstationFormDTO;
import br.com.icts.uqms.service.WorkstationService;
import br.com.icts.uqms.validations.handler.Existing;

@RestController
@RequestMapping("/register/workstation")
public class WorkstationController {

    @Autowired
    private WorkstationService service;

    @PostMapping
    public ResponseEntity<WorkstationDTO> create(@RequestBody @Validated(Existing.class) WorkstationFormDTO form ) {
        Workstation workstation = service.create(form);

        return new ResponseEntity<>(new WorkstationDTO(workstation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkstationDTO> update(@PathVariable Long id, @RequestBody @Valid WorkstationFormDTO form) {
        Workstation workstation = service.update(id, form);

        if(workstation == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new WorkstationDTO(workstation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Boolean deleted = service.delete(id);

        if(deleted) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public Page<WorkstationDTO> find(@RequestParam(required = false) String search,
            @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) { // buscar todos os elementos (com paginação)

        Page<Workstation> workstations = service.find(search, pagination);

        return WorkstationDTO.convert(workstations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkstationDTO> findById(@PathVariable Long id) { // buscar elemento por outra

        return service.findById(id);

    }


}