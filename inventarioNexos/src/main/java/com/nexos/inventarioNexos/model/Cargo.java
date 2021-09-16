package com.nexos.inventarioNexos.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cargo")
    private long id_cargo;

    @NotNull(message = "El nombre del cargo es obligatorio")
    @Column(name = "nombre_cargo")
    private String nombre_cargo;


}
