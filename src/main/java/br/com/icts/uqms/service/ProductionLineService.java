package br.com.icts.uqms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icts.uqms.repository.ProductionLineRepository;

@Service
public class ProductionLineService {

    @Autowired
    private ProductionLineRepository productionLineRepository;

    // this class connect with repository
}