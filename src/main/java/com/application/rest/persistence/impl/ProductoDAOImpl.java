package com.application.rest.persistence.impl;

import com.application.rest.entities.Producto;
import com.application.rest.persistence.IProductoDAO;
import com.application.rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements IProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> findByPriceRange(BigDecimal minPrecio, BigDecimal maxPrecio) {
        return productoRepository.findProductoByPrecioBetween(minPrecio, maxPrecio);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);

    }
}
