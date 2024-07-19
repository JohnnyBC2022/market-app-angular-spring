import { Cliente } from '../../model/Cliente';
import { MenuComponent } from '../menu/menu.component';
import { LoginService } from './../../service/login.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  usuario: string;
  password: string;
  client: Cliente;
  constructor(private loginService: LoginService, private menuComponent:MenuComponent) {

  }

  login() {
    this.loginService.login(this.usuario, this.password).subscribe(data => {
      this.client = data;
      if (this.client != null) { //usuario válido
        this.menuComponent.cliente=this.client;
        alert("Usuario autentificado");
      } else {
        alert("Usuario no autentificado")
      }
    });
  }
}
