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

@RestController
@RequestMapping("/register/workstation")
public class WorkstationController {

    @Autowired
    private WorkstationService workstationService;

    @PostMapping
    public ResponseEntity<WorkstationDTO> create(@RequestBody @Valid WorkstationFormDTO form ) {
        Workstation workstation = workstationService.create(form);

        return new ResponseEntity<>(new WorkstationDTO(workstation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkstationDTO> update(@PathVariable Long id, @RequestBody @Valid WorkstationFormDTO form) {
        Workstation workstation = workstationService.update(id, form);

        if(workstation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new WorkstationDTO(workstation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Boolean deleted = workstationService.delete(id);

        if(deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public Page<WorkstationDTO> find(@RequestParam(required = false) String search,
            @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) { // buscar todos os elementos (com paginação)

        Page<Workstation> workstations = workstationService.find(search, pagination);

        return WorkstationDTO.convert(workstations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkstationDTO> findById(@PathVariable Long id) { // buscar elemento por outra

        return workstationService.findById(id);

    }


}