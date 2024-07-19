import { ProcesarPedidoService } from './../../service/procesar-pedido.service';
import { Component, OnInit } from '@angular/core';
import { Categoria } from '../../model/Categoria';
import { Producto } from '../../model/Producto';
import { CestaItem } from '../../model/CestaItem';
import { MenuComponent } from '../menu/menu.component';

@Component({
  selector: 'app-procesar-pedido',
  templateUrl: './procesar-pedido.component.html',
  styleUrl: './procesar-pedido.component.css'
})
export class ProcesarPedidoComponent implements OnInit{
  categorias:Categoria[];
  productos:Producto[];
  idCategoriaSel:number;
  cesta:CestaItem[];

  constructor(private ProcesarPedidoService:ProcesarPedidoService, private menuComponent:MenuComponent){

  }

  ngOnInit(): void {
      this.ProcesarPedidoService.categorias().subscribe(c=>this.categorias=c)
      this.cesta=[];
  }

  productosCategoria(){
    this.ProcesarPedidoService.productosCategorias(this.idCategoriaSel).subscribe(p=>{
      this.productos=p
      this.actualizarStocks();
    });
  }
  actualizarStocks(){
    this.productos.forEach(p=>{
      this.cesta.forEach(c=>{
        //para cada producto de la categoría seleccionado recorremos la cesta de la compra, y si encontramos el producto en la cesta debemos actualizar su stock.
        if(p.idProducto==c.producto.idProducto){
          p.stock=p.stock-c.unidades;
        }
      })
    })
  }

  agregarProductoCesta(producto:Producto){
    if(producto.unidades <= producto.stock){
      let item=new CestaItem();
      item.producto=producto;
      item.unidades=producto.unidades;
      //actualizar stock
      producto.stock=producto.stock - producto.unidades;
      this.cesta.push(item);
    } else {
      alert("no hay stock suficiente");
    }
  }

  eliminarProductoCesta(pos:number){
    let item=this.cesta[pos];
    this.cesta.splice(pos,1)
    // localizamos el producto para actualizar el stock
    let producto=this.productos.find(p=>p.idProducto==item.producto.idProducto);
    producto.stock = Number(producto.stock) + Number(item.unidades);
  }

  procesarPedido(){
    this.ProcesarPedidoService.enviarPedido(this.cesta, this.menuComponent.cliente.usuario).subscribe({next:r=>alert("Pedido procesado correctamente"),error:e=>alert("El pedido no se ha podido procesar")}) //temporal hasta que lo conectemos todo
  }
}
