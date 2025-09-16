package com.denm_kaac.users.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private OffsetDateTime fecha = OffsetDateTime.now();

  @Column(nullable = false, length = 20)
  private String estado = "CREADO";

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<PedidoDetalle> detalles = new ArrayList<>();

  @Column(nullable = false)
  private Double total = 0.0;

  public Pedido() {}

  public void recalcTotal() {
    double sum = 0.0;
    for (PedidoDetalle d : detalles) {
      if (d.getSubtotal() != null) sum += d.getSubtotal();
    }
    this.total = sum;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public OffsetDateTime getFecha() { return fecha; }
  public void setFecha(OffsetDateTime fecha) { this.fecha = fecha; }

  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }

  public Cliente getCliente() { return cliente; }
  public void setCliente(Cliente cliente) { this.cliente = cliente; }

  public List<PedidoDetalle> getDetalles() { return detalles; }
  public void setDetalles(List<PedidoDetalle> detalles) { this.detalles = detalles; }

  public Double getTotal() { return total; }
  public void setTotal(Double total) { this.total = total; }
}
