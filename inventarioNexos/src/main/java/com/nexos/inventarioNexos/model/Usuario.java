package com.nexos.inventarioNexos.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "usuarios")
public class Usuario {

    //Id unico para el regisyto de los usuarios
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_usuario;

    @NotNull(message = "El nombre no puede ser Null")
    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @NotNull(message = "La edad no puede ser Null")
    @Column(name = "edad")
    private int edad;

    //relacion con la tabla cargos
    @Column(name = "id_cargo")
    private long id_cargo;

    @NotNull(message = "La cedula no puede ser Null")
    @Column(name = "cedula")
    private long cedula;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_ingreso;

    @ManyToOne
    @JoinColumn(name = "id_cargo", insertable = false,updatable = false)
    private Cargo cargo;

}
