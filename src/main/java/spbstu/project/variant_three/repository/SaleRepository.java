package spbstu.project.variant_three.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.project.variant_three.entity.Sale;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {
}
