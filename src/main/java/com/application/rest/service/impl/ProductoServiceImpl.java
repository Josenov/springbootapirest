package com.application.rest.service.impl;

import com.application.rest.entities.Producto;
import com.application.rest.persistence.IProductoDAO;
import com.application.rest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;
    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public List<Producto> findByPriceRange(BigDecimal minPrecio, BigDecimal maxPrecio) {
        return productoDAO.findByPriceRange(minPrecio, maxPrecio);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }
}
