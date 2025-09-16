package com.denm_kaac.users.controlador;

import com.denm_kaac.users.modelo.entidad.Cliente;
import com.denm_kaac.users.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin
public class ClienteControlador {
  @Autowired
  private ClienteService service;

  @GetMapping
  public List<Cliente> listar() { return service.listar(); }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> get(@PathVariable Long id) {
    return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Cliente> crear(@RequestBody Cliente body) {
    return ResponseEntity.ok(service.crear(body));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente body) {
    return ResponseEntity.ok(service.actualizar(id, body));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    service.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
