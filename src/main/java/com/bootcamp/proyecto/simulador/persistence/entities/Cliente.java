package com.bootcamp.proyecto.simulador.persistence.entities;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table (name="cliente")
public class Cliente {

    @Id
    @GeneratedValue
    @Column (name = "id")
    private Long id;

    @Column (name = "dni")
    private String dni;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "nroTarjeta")
    private String numeroTarjeta;

    @Column (name = "tipoTarjeta")
    private String tipoTarjeta;



}
