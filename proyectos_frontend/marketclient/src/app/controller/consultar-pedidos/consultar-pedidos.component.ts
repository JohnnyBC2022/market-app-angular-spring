import { Pedido } from '../../model/Pedido';
import { MenuComponent } from '../menu/menu.component';
import { ConsultarPedidosService } from './../../service/consultar-pedidos.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consultar-pedidos',
  templateUrl: './consultar-pedidos.component.html',
  styleUrl: './consultar-pedidos.component.css'
})
export class ConsultarPedidosComponent implements OnInit{
  usuario:string;
  pedidos: Pedido[];
  constructor(private ConsultarPedidosService:ConsultarPedidosService,private menuComponent:MenuComponent){

  }
  ngOnInit(): void {
    this.usuario=this.menuComponent.cliente.usuario;
    this.ConsultarPedidosService.consultarPedidos(this.usuario).subscribe(p=>this.pedidos=p)
  }
}
