package com.abel.practica_bazar.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_producto;

    String nombre;
    String marca;
    double costo;
    int stock;

    public void restar_stock(Integer cantidad){
        stock -= cantidad;
    }
}
