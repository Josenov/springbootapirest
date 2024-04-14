package com.application.rest.persistence.impl;

import com.application.rest.entities.Fabricante;
import com.application.rest.persistence.IFabricanteDAO;
import com.application.rest.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FabricanteDAOImpl implements IFabricanteDAO {

    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Override
    public List<Fabricante> findAll() {
        return (List<Fabricante>) fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> findById(Long id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
    }

    @Override
    public void deleteById(Long id) {
        fabricanteRepository.deleteById(id);

    }
}
