package com.application.rest.persistence;

import com.application.rest.entities.Fabricante;

import java.util.List;
import java.util.Optional;

public interface IFabricanteDAO {

    List<Fabricante> findAll(); //Para traer todos los fabricantes
    Optional<Fabricante> findById(Long id); //Para buscar por ID

    void save (Fabricante fabricante); // para guardar un fabricante

    void deleteById(Long id); //Para eliminar un fabricante
}
