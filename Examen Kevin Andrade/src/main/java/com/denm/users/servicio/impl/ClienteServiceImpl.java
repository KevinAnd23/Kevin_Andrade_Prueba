package com.denm_kaac.users.servicio.impl;

import com.denm_kaac.users.modelo.entidad.Cliente;
import com.denm_kaac.users.repositorio.ClienteRepositorio;
import com.denm_kaac.users.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*; 

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
  @Autowired
  private ClienteRepositorio repo;
  public List<Cliente> listar(){ return repo.findAll(); }
  public Optional<Cliente> obtener(Long id){ return repo.findById(id); }
  public Cliente crear(Cliente c){ return repo.save(c); }
  public Cliente actualizar(Long id, Cliente c){
    return repo.findById(id).map(db -> {
      db.setNombre(c.getNombre());
      db.setEmail(c.getEmail());
      db.setTelefono(c.getTelefono());
      db.setDireccion(c.getDireccion());
      return repo.save(db);
    }).orElseThrow();
  }
  public void eliminar(Long id){ repo.deleteById(id); }
}
