package com.denm_kaac.users.modelo.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clientes")
public class Cliente {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank @Column(nullable = false, length = 120)
  private String nombre;

  @Email @NotBlank @Column(nullable = false, unique = true, length = 120)
  private String email;

  @NotBlank @Column(nullable = false, length = 20)
  private String telefono;

  @NotBlank @Column(nullable = false, length = 200)
  private String direccion;

  public Cliente() {}

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getTelefono() { return telefono; }
  public void setTelefono(String telefono) { this.telefono = telefono; }

  public String getDireccion() { return direccion; }
  public void setDireccion(String direccion) { this.direccion = direccion; }
}
