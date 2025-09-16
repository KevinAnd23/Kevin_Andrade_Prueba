package com.denm_kaac.users.servicio.impl;

import com.denm_kaac.users.modelo.entidad.PedidoDetalle;
import com.denm_kaac.users.repositorio.PedidoDetalleRepositorio;
import com.denm_kaac.users.servicio.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*; 

@Service
@Transactional
public class PedidoDetalleServiceImpl implements PedidoDetalleService {
  @Autowired
  private PedidoDetalleRepositorio repo;
  public List<PedidoDetalle> listar(){ return repo.findAll(); }
  public Optional<PedidoDetalle> obtener(Long id){ return repo.findById(id); }
  public PedidoDetalle crear(PedidoDetalle d){
    if (d.getSubtotal()==null) d.setSubtotal(d.getPrecioUnitario()*d.getCantidad());
    return repo.save(d);
  }
  public PedidoDetalle actualizar(Long id, PedidoDetalle d){
    return repo.findById(id).map(db -> {
      db.setProducto(d.getProducto());
      db.setCantidad(d.getCantidad());
      db.setPrecioUnitario(d.getPrecioUnitario());
      db.setSubtotal(d.getPrecioUnitario()*d.getCantidad());
      return repo.save(db);
    }).orElseThrow();
  }
  public void eliminar(Long id){ repo.deleteById(id); }
}
