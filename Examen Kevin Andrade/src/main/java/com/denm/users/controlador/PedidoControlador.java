package com.denm_kaac.users.controlador;

import com.denm_kaac.users.modelo.entidad.Pedido;
import com.denm_kaac.users.servicio.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin
public class PedidoControlador {
  @Autowired
  private PedidoService service;

  @GetMapping
  public List<Pedido> listar() { return service.listar(); }

  @GetMapping("/{id}")
  public ResponseEntity<Pedido> get(@PathVariable Long id) {
    return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Pedido> crear(@RequestBody Pedido body) {
    return ResponseEntity.ok(service.crear(body));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pedido> actualizar(@PathVariable Long id, @RequestBody Pedido body) {
    return ResponseEntity.ok(service.actualizar(id, body));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    service.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
