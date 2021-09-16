import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Usuario } from "src/app/model/Inventario.model";
import { ProductoService } from "src/app/services/producto.service";
import { UsuarioService } from "src/app/services/usuario.service";
import { Producto } from "../../model/Inventario.model";
import Swal from "sweetalert2";
@Component({
  selector: "app-producto",
  templateUrl: "./producto.component.html",
  styleUrls: ["./producto.component.css"],
})
export class ProductoComponent implements OnInit {
  form: FormGroup;

  usuario: Usuario[];
  productos: Producto[];
  producto: any;
  state: boolean = true;
  constructor(
    private usuarioService: UsuarioService,
    private productoService: ProductoService,
    private fb: FormBuilder
  ) {
    this.createForm();
  }

  ngOnInit() {
    this.getAllProducto();
    this.getUsuarioAll();
  }

  createForm() {
    this.form = this.fb.group({
      id_producto: [],
      nombre: ["", Validators.required],
      cantidad: [null, Validators.required],
      fecha_ingreso: ["", Validators.required],
      id_usuario_registro: [null, Validators.required],
      id_usuario_modifica: [1, Validators.required],
    });
  }

  get NameInvalid() {
    return this.form.get("nombre").invalid && this.form.get("nombre").touched;
  }

  get CantidadInvalid() {
    return (
      this.form.get("cantidad").invalid && this.form.get("cantidad").touched
    );
  }
  get UsuarioInvalid() {
    return (
      this.form.get("id_usuario_registro").invalid &&
      this.form.get("id_usuario_registro").touched
    );
  }

  get FechaInvalid() {
    return (
      this.form.get("fecha_ingreso").invalid &&
      this.form.get("fecha_ingreso").touched
    );
  }

  get ModificaInvalid() {
    return (
      this.form.get("id_usuario_modifica").invalid &&
      this.form.get("id_usuario_modifica").touched
    );
  }
  getAllProducto() {
    this.productoService.getProductoAll().subscribe((producto: any) => {
      this.productos = producto;
    });
  }

  getUsuarioAll() {
    this.usuarioService.getUsuarioAll().subscribe((usuario: any) => {
      this.usuario = usuario;
    });
  }

  createProducto() {
    if (this.form.invalid) {
      return Object.values(this.form.controls).forEach((control) => {
        if (control instanceof FormGroup) {
          Object.values(control.controls).forEach((control) => {
            control.markAllAsTouched();
          });
        } else {
          control.markAllAsTouched();
        }
      });
    } else if (this.form.value.id_producto === null) {
      this.productoService.postProducto(this.form.value).subscribe(
        (producto: any) => {
          this.productos = [...this.productos, producto];
          Swal.fire("Producto Creado");
          this.resetFormulario();
        },
        (error) => {
          Swal.fire(error.error.message);
        }
      );
    } else {
      this.state = false;
      this.productoService
        .putProducto(this.form.value)
        .subscribe((produ: any) => {
          this.state = true;
          this.getAllProducto();
          Swal.fire("Producto Editado");
          this.resetFormulario();
        });
    }
  }

  resetFormulario() {
    this.form.reset({
      nombre: "",
      cantidad: null,
      fecha_ingreso: "",
      id_usuario_registro: null,
    });
  }

  handleDeleteProducto(id: number) {
    Swal.fire({
      title: "Desear Eliminar el Producto?",
      text: "Eliminar el Producto",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Eliminar!",
    }).then((borrar) => {
      if (borrar.value) {
        this.productoService.deleteProject(id).subscribe(() => {
          this.getAllProducto();
        });
      }
    });
  }

  handleEditProducto(producto: Producto) {
    this.state = false;
    this.form.setValue({
      id_producto: producto.id_producto,
      nombre: producto.nombre,
      cantidad: producto.cantidad,
      fecha_ingreso: producto.fecha_ingreso,
      id_usuario_registro: producto.id_usuario_registro,
      id_usuario_modifica: producto.id_usuario_modifica,
    });
  }
}
