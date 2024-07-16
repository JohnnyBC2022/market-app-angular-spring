import { ProcesarPedidoService } from './../../service/procesar-pedido.service';
import { Component, OnInit } from '@angular/core';
import { Categoria } from '../../model/Categoria';
import { Producto } from '../../model/Producto';

@Component({
  selector: 'app-procesar-pedido',
  templateUrl: './procesar-pedido.component.html',
  styleUrl: './procesar-pedido.component.css'
})
export class ProcesarPedidoComponent implements OnInit{
  categorias:Categoria[];
  productos:Producto[];
  idCategoriaSel:number;

  constructor(private ProcesarPedidoService:ProcesarPedidoService){

  }

  ngOnInit(): void {
      this.ProcesarPedidoService.categorias().subscribe(c=>this.categorias=c)
  }

  productosCategoria(){
    this.ProcesarPedidoService.productosCategorias(this.idCategoriaSel).subscribe(p=>this.productos=p);
  }
}
