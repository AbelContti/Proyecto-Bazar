package com.abel.practica_bazar.service;
import com.abel.practica_bazar.model.Producto;
import com.abel.practica_bazar.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepo;

    public List<Producto> getProductos(){
        return productoRepo.findAll();
    }

    public Producto getProducto(Long id) { return productoRepo.findById(id).orElse(null);}

    public void saveOrEdit(Producto producto){
        productoRepo.save(producto);
    }

    public List<Producto> getProductosBajoStock(){
        return productoRepo.findProductosWithLowStock();
    }

    public void deleteProducto(Long id){
        productoRepo.deleteById(id);
    }
}
