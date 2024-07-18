import { Pedido } from '../../model/Pedido';
import { ConsultarPedidosService } from './../../service/consultar-pedidos.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consultar-pedidos',
  templateUrl: './consultar-pedidos.component.html',
  styleUrl: './consultar-pedidos.component.css'
})
export class ConsultarPedidosComponent implements OnInit{
  usuario: string;
  pedidos: Pedido[];
  constructor(private ConsultarPedidosService:ConsultarPedidosService){

  }
  ngOnInit(): void {
    this.ConsultarPedidosService.consultarPedidos("user1").subscribe(p=>this.pedidos=p)
  }
}
