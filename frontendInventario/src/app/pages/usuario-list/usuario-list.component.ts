import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from 'src/app/model/Inventario.model';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit {

  @Input() usuarios : Usuario;

  constructor() { }

  ngOnInit() {    
  }

}
