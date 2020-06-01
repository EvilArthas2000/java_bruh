package spbstu.project.variant_three.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.project.variant_three.entity.Warehouse2;
import spbstu.project.variant_three.repository.Warehouse2Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class Warehouse2Service implements CrudService<Warehouse2> {
  private final Warehouse2Repository warehouse2Repository;

  @Override
  public Warehouse2 save(Warehouse2 warehouse1) {
    return warehouse2Repository.save(warehouse1);
  }

  @Override
  public List<Warehouse2> getAll() {
    return StreamSupport
        .stream(warehouse2Repository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Warehouse2 update(Warehouse2 source, Warehouse2 dist) {
    BeanUtils.copyProperties(source, dist, "id");

    return warehouse2Repository.save(dist);
  }

  @Override
  public void delete(Warehouse2 warehouse1) {
    warehouse2Repository.delete(warehouse1);
  }
}
