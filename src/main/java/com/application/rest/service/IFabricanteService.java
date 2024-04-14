package com.application.rest.service;

import com.application.rest.entities.Fabricante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IFabricanteService {

    List<Fabricante> findAll();
    Optional<Fabricante> findById(Long id);

    void save (Fabricante fabricante);

    void deleteById(Long id);
}
