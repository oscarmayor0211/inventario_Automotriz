import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { UsuarioListComponent } from './pages/usuario-list/usuario-list.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { ProductoListComponent } from './pages/producto-list/producto-list.component';
import { CargoComponent } from './pages/cargo/cargo.component';
import { CargoListComponent } from './pages/cargo-list/cargo-list.component';
@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    UsuarioListComponent,
    ProductoComponent,
    ProductoListComponent,
    CargoComponent,
    CargoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
