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
  pedidos: Pedido[];
  constructor(private ConsultarPedidosService:ConsultarPedidosService,private menuComponent:MenuComponent){

  }
  ngOnInit(): void {
    this.ConsultarPedidosService.consultarPedidos(this.menuComponent.cliente.usuario).subscribe(p=>this.pedidos=p)
  }
}
