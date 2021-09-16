import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL_SERVICE } from '../config/config';
import { Producto } from '../model/Inventario.model';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http : HttpClient) { }


getProductoAll(){
  let Url = URL_SERVICE + "/producto";
  return this.http.get(Url);
}

getProductoFilter(nombre:String){
  let Url = URL_SERVICE + "/producto/" + nombre;
  return this.http.get(Url);
}


postProducto(producto: Producto){
  let Url = URL_SERVICE + "/producto";
  return this.http.post(Url,producto);
}

putProducto(producto: Producto) {
  let url = URL_SERVICE + "/producto/" + producto.id_producto;
  return this.http.put(url, producto);
}

deleteProject(id: number) {
  let url = URL_SERVICE + "/producto/" + id ;
  return this.http.delete(url);
}
}