package com.nexos.inventarioNexos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private long id_producto;

    //debe de ser unico el nombre del producto
    @NotNull(message = "El nombre no puede ser Null")
    @Column(name = "nombre",unique = true,nullable = false)
    private String nombre;

    //debe de ser solo entero
    @NotNull(message = "La cantidad no puede ser Null")
    @Column(name = "cantidad")
    private Integer cantidad;

    //debe de ser <= a la fecha
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_ingreso;

    //relacion con tabla de usuario
    @Column(name = "id_usuario_registro")
    private long id_usuario_registro;

    @Column(name = "id_usuario_modifica")
    private long id_usuario_modifica;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fecha_update;

    @ManyToOne
    @JoinColumn(name = "id_usuario_registro", insertable = false,updatable = false)
    private Usuario usuarioregistro;

    @ManyToOne
    @JoinColumn(name = "id_usuario_modifica", insertable = false,updatable = false)
    private Usuario usuariomodifica;
}
