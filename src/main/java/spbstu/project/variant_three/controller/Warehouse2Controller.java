package spbstu.project.variant_three.controller;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import spbstu.project.variant_three.entity.Warehouse2;
import spbstu.project.variant_three.service.CrudService;
import spbstu.project.variant_three.service.Warehouse2Service;

import java.util.List;

@RestController
@RequestMapping("api")
public class Warehouse2Controller {
  private final CrudService<Warehouse2> service;

  public Warehouse2Controller(Warehouse2Service service) {
    this.service = service;
  }

  @GetMapping("warehouse2")
  @PreAuthorize("isAuthenticated()")
  public List<Warehouse2> getAll() {
    return service.getAll();
  }

  @GetMapping("warehouse2/{id}")
  @PreAuthorize("isAuthenticated()")
  public Warehouse2 getOne(@PathVariable("id") Warehouse2 warehouse2) {
    return warehouse2;
  }

  @PostMapping("warehouse2")
  @PreAuthorize("isAuthenticated()")
  public Warehouse2 saveOne(@RequestBody Warehouse2 warehouse2) {
    return service.save(warehouse2);
  }

  @PutMapping("warehouse2/{id}")
  @PreAuthorize("isAuthenticated()")
  public Warehouse2 updateOne(@PathVariable("id") Warehouse2 warehouse2FromDb,
                              @RequestBody Warehouse2 updatedWarehouse2) {

    return service.update(updatedWarehouse2, warehouse2FromDb);
  }

  @DeleteMapping("warehouse2/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Warehouse2 warehouse2) {
    service.delete(warehouse2);
  }
}
