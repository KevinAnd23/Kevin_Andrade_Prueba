package com.denm_kaac.users.servicio.impl;

import com.denm_kaac.users.modelo.entidad.*;
import com.denm_kaac.users.repositorio.PedidoRepositorio;
import com.denm_kaac.users.servicio.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*; 

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {
  @Autowired
  private PedidoRepositorio repo;
  public List<Pedido> listar(){ return repo.findAll(); }
  public Optional<Pedido> obtener(Long id){ return repo.findById(id); }
  public Pedido crear(Pedido p){
    if (p.getDetalles()!=null){
      for (PedidoDetalle d: p.getDetalles()){
        d.setPedido(p);
        if (d.getPrecioUnitario()==null && d.getProducto()!=null){
          d.setPrecioUnitario(d.getProducto().getPrecio());
        }
        d.setSubtotal(d.getPrecioUnitario() * d.getCantidad());
      }
      p.recalcTotal();
    }
    return repo.save(p);
  }
  public Pedido actualizar(Long id, Pedido p){
    return repo.findById(id).map(db -> {
      db.setEstado(p.getEstado());
      db.setCliente(p.getCliente());
      db.getDetalles().clear();
      if (p.getDetalles()!=null){
        for (PedidoDetalle d: p.getDetalles()){
          d.setPedido(db);
          if (d.getPrecioUnitario()==null && d.getProducto()!=null){
            d.setPrecioUnitario(d.getProducto().getPrecio());
          }
          d.setSubtotal(d.getPrecioUnitario() * d.getCantidad());
          db.getDetalles().add(d);
        }
      }
      db.recalcTotal();
      return repo.save(db);
    }).orElseThrow();
  }
  public void eliminar(Long id){ repo.deleteById(id); }
}
