import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Producto } from 'src/app/model/Inventario.model';

@Component({
  selector: 'app-producto-list',
  templateUrl: './producto-list.component.html',
  styleUrls: ['./producto-list.component.css']
})
export class ProductoListComponent implements OnInit {

  @Input() productos : Producto;
  @Output() editProducto = new EventEmitter<Producto>();
  @Output() deletProducto = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }
  llenarForm(producto: Producto) {
    this.editProducto.emit(producto);
  }

  deleteProducto(id: number) {
    this.deletProducto.emit(id);
  }
}
