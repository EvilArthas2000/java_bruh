package spbstu.project.variant_three.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.project.variant_three.entity.Warehouse1;

@Repository
public interface Warehouse1Repository extends CrudRepository<Warehouse1,Long> {
}
