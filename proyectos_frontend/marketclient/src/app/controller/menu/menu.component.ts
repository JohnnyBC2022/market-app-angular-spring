import { Component } from '@angular/core';
import { Cliente } from '../../model/Cliente';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  enabled:boolean=false; //nos sirve para habilitar o deshabilitar ciertos enlaces (ya que si no hay usuario logueado no puede acceder a toda la aplicación)
  cliente:Cliente;
}
