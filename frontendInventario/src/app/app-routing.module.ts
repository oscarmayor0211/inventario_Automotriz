import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CargoComponent } from './pages/cargo/cargo.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';


const routes: Routes = [
  {path : "productos", component: ProductoComponent},
  {path: "cargos", component: CargoComponent},
  {path: "usuarios", component: UsuarioComponent} ,
  { path: "**", redirectTo: "productos", pathMatch: "full" },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
