import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URL_SERVICE } from '../config/config';
import { Cargo } from '../model/Inventario.model';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  constructor(private http : HttpClient) { }

  getCargosAll(){
    let Url = URL_SERVICE + "/cargo";
    return this.http.get(Url);
  }

  postCargo(cargo: Cargo){
    let Url = URL_SERVICE + "/cargo";
    return this.http.post(Url,cargo);
  }
}
