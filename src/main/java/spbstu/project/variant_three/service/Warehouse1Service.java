package spbstu.project.variant_three.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.project.variant_three.entity.Warehouse1;
import spbstu.project.variant_three.repository.Warehouse1Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class Warehouse1Service implements CrudService<Warehouse1> {
  private final Warehouse1Repository warehouse1Repository;

  @Override
  public Warehouse1 save(Warehouse1 warehouse1) {
    return warehouse1Repository.save(warehouse1);
  }

  @Override
  public List<Warehouse1> getAll() {
    return StreamSupport
        .stream(warehouse1Repository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Warehouse1 update(Warehouse1 source, Warehouse1 dist) {
    BeanUtils.copyProperties(source, dist, "id");

    return warehouse1Repository.save(dist);
  }

  @Override
  public void delete(Warehouse1 warehouse1) {
    warehouse1Repository.delete(warehouse1);
  }
}
