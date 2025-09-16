package com.denm_kaac.users.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "productos")
public class Producto {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank @Column(nullable = false, length = 120)
  private String nombre;

  @Positive @Column(nullable = false)
  private Double precio;

  @PositiveOrZero @Column(nullable = false)
  private Integer stock;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "categoria_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
  private Categoria categoria;

  public Producto() {}

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public Double getPrecio() { return precio; }
  public void setPrecio(Double precio) { this.precio = precio; }

  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }

  public Categoria getCategoria() { return categoria; }
  public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
