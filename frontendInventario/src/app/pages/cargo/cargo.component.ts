import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Cargo } from "src/app/model/Inventario.model";
import { CargoService } from "src/app/services/cargo.service";
import Swal from "sweetalert2";

@Component({
  selector: "app-cargo",
  templateUrl: "./cargo.component.html",
  styleUrls: ["./cargo.component.css"],
})
export class CargoComponent implements OnInit {
  cargos: Cargo[];
  form: FormGroup;
  constructor(
    private cargoService: CargoService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit() {
    this.createForm();
    this.getCargoAll();
  }

  createForm() {
    this.form = this.fb.group({
      id_cargo: [],
      nombre_cargo: ["", Validators.required],
    });
  }

  get NameInvalid() {
    return (
      this.form.get("nombre_cargo").invalid &&
      this.form.get("nombre_cargo").touched
    );
  }

  getCargoAll() {
    this.cargoService.getCargosAll().subscribe((cargos: any) => {
      this.cargos = cargos;
    });
  }

  createCargo() {
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
    } else if (this.form.value.id_cargo === null) {
      this.cargoService.postCargo(this.form.value).subscribe((cargo: any) => {
        this.cargos = [...this.cargos, cargo];
        Swal.fire("Cargo Creado");
        this.resetFormulario();
      });
    }
  }

  resetFormulario() {
    this.form.reset({
      nombre_cargo: "",
    });
  }

  cancel() {
    this.router.navigateByUrl("/productos");
  }
}
