package com.denm_kaac.users.controlador;

import com.denm_kaac.users.modelo.entidad.PedidoDetalle;
import com.denm_kaac.users.servicio.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@CrossOrigin
public class PedidoDetalleControlador {
  @Autowired
  private PedidoDetalleService service;

  @GetMapping
  public List<PedidoDetalle> listar() { return service.listar(); }

  @GetMapping("/{id}")
  public ResponseEntity<PedidoDetalle> get(@PathVariable Long id) {
    return service.obtener(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<PedidoDetalle> crear(@RequestBody PedidoDetalle body) {
    return ResponseEntity.ok(service.crear(body));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PedidoDetalle> actualizar(@PathVariable Long id, @RequestBody PedidoDetalle body) {
    return ResponseEntity.ok(service.actualizar(id, body));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    service.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
