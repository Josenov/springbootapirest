package com.application.rest.repository;

import com.application.rest.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository <Producto, Long> {
    //@Query("SELECT P FROM Producto p WHERE p.precio BETWEEN ?1 AND ?2")
    //List<Producto> findProductoByRangoDePrecio(BigDecimal minPrecio, BigDecimal maxPrecio);
    List<Producto> findProductoByPrecioBetween(BigDecimal minPrecio, BigDecimal maxPrecio);
}
