package com.denm_kaac.users.servicio.impl;

import com.denm_kaac.users.modelo.entidad.Categoria;
import com.denm_kaac.users.repositorio.CategoriaRepositorio;
import com.denm_kaac.users.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*; 

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
  @Autowired
  private CategoriaRepositorio repo;
  public List<Categoria> listar(){ return repo.findAll(); }
  public Optional<Categoria> obtener(Long id){ return repo.findById(id); }
  public Categoria crear(Categoria c){ return repo.save(c); }
  public Categoria actualizar(Long id, Categoria c){
    return repo.findById(id).map(db -> { db.setNombre(c.getNombre()); return repo.save(db); }).orElseThrow();
  }
  public void eliminar(Long id){ repo.deleteById(id); }
}
