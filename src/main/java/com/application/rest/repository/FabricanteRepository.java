package com.application.rest.repository;

import com.application.rest.entities.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricanteRepository extends CrudRepository <Fabricante, Long> {

}
