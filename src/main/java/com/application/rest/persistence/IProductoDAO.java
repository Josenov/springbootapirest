package com.application.rest.persistence;

import com.application.rest.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductoDAO {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);

    void save(Producto producto);

    List<Producto> findByPriceRange(BigDecimal minPrecio, BigDecimal maxPrecio);
    //obtiene una lista ordenada por precio
    void deleteById(Long id);
}
