import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL_SERVICE } from '../config/config';
import { Usuario } from '../model/Inventario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http : HttpClient) { }

  getUsuarioAll() {
    let url = URL_SERVICE + "/usuario";
    return this.http.get(url);
  }

  postProject(usuario: Usuario) {
    let url = URL_SERVICE + "/usuario";
    return this.http.post(url, usuario);
  }
}
