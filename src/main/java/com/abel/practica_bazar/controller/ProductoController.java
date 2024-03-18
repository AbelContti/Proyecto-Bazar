package com.abel.practica_bazar.controller;
import com.abel.practica_bazar.model.Producto;
import com.abel.practica_bazar.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/productos")
@RestController
public class ProductoController {
    @Autowired
    ProductoService productoServ;

    @GetMapping("/traer")
    public List<Producto> getProductos(){
        return productoServ.getProductos();
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable Long id){
        return productoServ.getProducto(id);
    }

    @GetMapping("/falta_stock")
    public List<Producto> getProductosPocoStock(){
        return productoServ.getProductosBajoStock();
    }

    @PostMapping("/agregar")
    public void saveProducto(@RequestBody Producto producto){
        productoServ.saveOrEdit(producto);
    }

    @PutMapping("/editar")
    public void editProducto(@RequestBody Producto producto){
        productoServ.saveOrEdit(producto);
    }

    @DeleteMapping("/borrar")
    public void deleteProducto(@PathVariable Long id){
        productoServ.deleteProducto(id);
    }
}
