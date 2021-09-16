import { Component, Input, OnInit } from '@angular/core';
import { Cargo } from '../../model/Inventario.model';

@Component({
  selector: 'app-cargo-list',
  templateUrl: './cargo-list.component.html',
  styleUrls: ['./cargo-list.component.css']
})
export class CargoListComponent implements OnInit {
  @Input() cargos : Cargo;
  constructor() { }

  ngOnInit() {
  }

}
