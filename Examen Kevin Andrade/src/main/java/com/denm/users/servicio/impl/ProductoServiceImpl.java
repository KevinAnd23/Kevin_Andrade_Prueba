package com.denm_kaac.users.servicio.impl;

import com.denm_kaac.users.modelo.entidad.Producto;
import com.denm_kaac.users.repositorio.ProductoRepositorio;
import com.denm_kaac.users.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*; 

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
  @Autowired
  private ProductoRepositorio repo;
  public List<Producto> listar(){ return repo.findAll(); }
  public Optional<Producto> obtener(Long id){ return repo.findById(id); }
  public Producto crear(Producto p){ return repo.save(p); }
  public Producto actualizar(Long id, Producto p){
    return repo.findById(id).map(db -> {
      db.setNombre(p.getNombre());
      db.setPrecio(p.getPrecio());
      db.setStock(p.getStock());
      db.setCategoria(p.getCategoria());
      return repo.save(db);
    }).orElseThrow();
  }
  public void eliminar(Long id){ repo.deleteById(id); }
}
