package com.denm_kaac.users.servicio;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
  List<T> listar();
  Optional<T> obtener(ID id);
  T crear(T t);
  T actualizar(ID id, T t);
  void eliminar(ID id);
}
