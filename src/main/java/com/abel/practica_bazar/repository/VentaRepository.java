package com.abel.practica_bazar.repository;
import com.abel.practica_bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFecha(LocalDate fecha);

    Venta findFirstByOrderByMontoDesc();
}
