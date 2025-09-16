package com.denm_kaac.users.controlador;

import com.denm_kaac.users.modelo.entidad.Producto;
import com.denm_kaac.users.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin
public class ProductoControlador {
  @Autowired
  private ProductoService service;

  @GetMapping
  public List<Producto> listar() { return service.listar(); }

  @GetMapping("/{id}")
  public ResponseEntity<Producto> get(@PathVariable Long id) {
    return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Producto> crear(@RequestBody Producto body) {
    return ResponseEntity.ok(service.crear(body));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto body) {
    return ResponseEntity.ok(service.actualizar(id, body));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    service.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
