package com.abel.practica_bazar.repository;
import com.abel.practica_bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.stock <= 20")
    List<Producto> findProductosWithLowStock();
}
