package spbstu.project.variant_three.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.project.variant_three.entity.Good;

@Repository
public interface GoodRepository extends CrudRepository<Good, Long> {
}
