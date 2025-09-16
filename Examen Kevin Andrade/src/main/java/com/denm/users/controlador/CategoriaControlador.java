package com.denm_kaac.users.controlador;

import com.denm_kaac.users.modelo.entidad.Categoria;
import com.denm_kaac.users.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin
public class CategoriaControlador {
  @Autowired
  private CategoriaService service;

  @GetMapping
  public List<Categoria> listar() { return service.listar(); }

  @GetMapping("/{id}")
  public ResponseEntity<Categoria> get(@PathVariable Long id) {
    return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Categoria> crear(@RequestBody Categoria body) {
    return ResponseEntity.ok(service.crear(body));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria body) {
    return ResponseEntity.ok(service.actualizar(id, body));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    service.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
