package com.denm_kaac.users.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "pedido_detalles")
public class PedidoDetalle {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "pedido_id")
  @JsonBackReference
  private Pedido pedido;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "producto_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
  private Producto producto;

  @Positive @Column(nullable = false)
  private Integer cantidad;

  @Positive @Column(nullable = false)
  private Double precioUnitario;

  @Positive @Column(nullable = false)
  private Double subtotal;

  public PedidoDetalle() {}

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Pedido getPedido() { return pedido; }
  public void setPedido(Pedido pedido) { this.pedido = pedido; }

  public Producto getProducto() { return producto; }
  public void setProducto(Producto producto) { this.producto = producto; }

  public Integer getCantidad() { return cantidad; }
  public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

  public Double getPrecioUnitario() { return precioUnitario; }
  public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

  public Double getSubtotal() { return subtotal; }
  public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
}
