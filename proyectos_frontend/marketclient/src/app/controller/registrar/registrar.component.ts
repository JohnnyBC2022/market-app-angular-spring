import { Cliente } from '../../model/Cliente';
import { RegistrarService } from './../../service/registrar.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrl: './registrar.component.css'
})
export class RegistrarComponent {
  cliente:Cliente = new Cliente();
  constructor(private RegistrarService:RegistrarService){
  }
  registrar(){
    this.RegistrarService.registrar(this.cliente).subscribe({
      next:data=>alert("Usuario registrado"),
      error:err=>alert("Usuario ya existe, no se pudo registrar!")
    })
  }
}
