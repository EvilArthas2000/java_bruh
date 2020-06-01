package spbstu.project.variant_three.service;

import java.util.List;

public interface CrudService<T> {
  T save(T t);

  List<T> getAll();

  T update(T source, T dist);

  void delete(T t);
}
