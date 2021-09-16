import { Component, OnInit } from "@angular/core";
import { UsuarioService } from "../../services/usuario.service";
import { Usuario, Cargo } from "../../model/Inventario.model";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { CargoService } from "src/app/services/cargo.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-usuario",
  templateUrl: "./usuario.component.html",
  styleUrls: ["./usuario.component.css"],
})
export class UsuarioComponent implements OnInit {
  usuarios: Usuario[];
  cargos: Cargo[] = [];
  form: FormGroup;

  constructor(
    private usuarioService: UsuarioService,
    private fb: FormBuilder,
    private cargoService: CargoService,
    private router: Router
  ) {}

  ngOnInit() {
    this.createForm();
    this.getUsuarioAll();
    this.getCargoAll();
  }

  createForm() {
    this.form = this.fb.group({
      id: [],
      nombre_usuario: ["", Validators.required],
      edad: [null, Validators.required],
      fecha_ingreso: ["", Validators.required],
      id_cargo: [null, Validators.required],
      cedula: [null,Validators.required]
    });
  }

  get NameInvalid() {
    return (
      this.form.get("nombre_usuario").invalid &&
      this.form.get("nombre_usuario").touched
    );
  }

  get EdadInvalid() {
    return this.form.get("edad").invalid && this.form.get("edad").touched;
  }

  get FechaInvalid() {
    return (
      this.form.get("fecha_ingreso").invalid &&
      this.form.get("fecha_ingreso").touched
    );
  }

  get CedulaInvalid() {
    return (
      this.form.get("cedula").invalid &&
      this.form.get("cedula").touched
    );
  }

  get CargoInvalid() {
    return (
      this.form.get("id_cargo").invalid && this.form.get("id_cargo").touched
    );
  }

  getUsuarioAll() {
    this.usuarioService.getUsuarioAll().subscribe((usuario: any) => {
      this.usuarios = usuario;
    });
  }

  getCargoAll() {
    this.cargoService.getCargosAll().subscribe((cargos: any) => {
      this.cargos = cargos;
    });
  }

  createUsuario() {
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
    } else if (this.form.value.id === null) {
      this.usuarioService
        .postProject(this.form.value)
        .subscribe((usuario: any) => {
          this.usuarios = [...this.usuarios, usuario];
        });
    }
  }

  cancel() {
    this.router.navigateByUrl("/productos");
  }
}
