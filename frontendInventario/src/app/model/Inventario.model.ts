export interface Producto {
    id_producto: number;
    nombre: string;
    cantidad: number;
    fecha_ingreso: Date;
    id_usuario_modifica: Usuario;
    id_usuario_registro: Usuario;
    fecha_update: Date;
}

export interface Usuario {
    id_usuario: number;
    cedula: number,
    nombre_usuario: string;
    edad: number;
    fecha_ingreso: Date;
    id_cargo: Cargo;
}

export interface Cargo {
    id_cargo: number;
    nombre_cargo: String;
}
