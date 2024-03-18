package com.abel.practica_bazar.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter


@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;

    @OneToMany
    @JoinTable(
            name = "venta_pedidos",
            joinColumns = @JoinColumn(name = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido"))
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private double monto;
    private LocalDate fecha;
}

