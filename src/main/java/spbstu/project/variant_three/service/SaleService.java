package spbstu.project.variant_three.service;

import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import spbstu.project.variant_three.entity.Sale;
import spbstu.project.variant_three.repository.SaleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SaleService implements CrudService<Sale> {
  private final SaleRepository saleRepository;

  @Override
  public Sale save(Sale sale) {
    return saleRepository.save(sale);
  }

  @Override
  public List<Sale> getAll() {
    return StreamSupport
        .stream(saleRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Sale update(Sale source, Sale dist) {
    BeanUtils.copyProperties(source, dist, "id");

    return saleRepository.save(dist);
  }

  @Override
  public void delete(Sale sale) {
    saleRepository.delete(sale);
  }
}
