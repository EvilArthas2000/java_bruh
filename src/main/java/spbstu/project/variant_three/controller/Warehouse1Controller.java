package spbstu.project.variant_three.controller;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import spbstu.project.variant_three.entity.Warehouse1;
import spbstu.project.variant_three.service.CrudService;
import spbstu.project.variant_three.service.Warehouse1Service;

import java.util.List;

@RestController
@RequestMapping("api")
public class Warehouse1Controller {
  private final CrudService<Warehouse1> service;

  public Warehouse1Controller(Warehouse1Service service) {
    this.service = service;
  }

  @GetMapping("warehouse1")
  @PreAuthorize("isAuthenticated()")
  public List<Warehouse1> getAll() {
    return service.getAll();
  }

  @GetMapping("warehouse1/{id}")
  @PreAuthorize("isAuthenticated()")
  public Warehouse1 getOne(@PathVariable("id") Warehouse1 warehouse1) {
    return warehouse1;
  }

  @PostMapping("warehouse1")
  @PreAuthorize("isAuthenticated()")
  public Warehouse1 saveOne(@RequestBody Warehouse1 warehouse1) {
    return service.save(warehouse1);
  }

  @PutMapping("warehouse1/{id}")
  @PreAuthorize("isAuthenticated()")
  public Warehouse1 updateOne(@PathVariable("id") Warehouse1 warehouse1FromDb,
                              @RequestBody Warehouse1 updatedWarehouse1) {
    return service.update(updatedWarehouse1, warehouse1FromDb);
  }

  @DeleteMapping("warehouse1/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Warehouse1 warehouse1) {
    service.delete(warehouse1);
  }
}
