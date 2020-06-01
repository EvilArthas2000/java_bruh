package spbstu.project.variant_three.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.project.variant_three.entity.Good;
import spbstu.project.variant_three.repository.GoodRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GoodService implements CrudService<Good> {
  private final GoodRepository goodRepository;

  @Override
  public Good save(Good good) {
    return goodRepository.save(good);
  }

  @Override
  public List<Good> getAll() {
    return StreamSupport.stream(goodRepository.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public Good update(Good source, Good dist) {
    BeanUtils.copyProperties(source, dist, "id");

    return goodRepository.save(dist);
  }

  @Override
  public void delete(Good good) {
    goodRepository.delete(good);
  }
}
