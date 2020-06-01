package spbstu.project.variant_three.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.project.variant_three.entity.Sale;
import spbstu.project.variant_three.service.CrudService;
import spbstu.project.variant_three.service.SaleService;


import java.util.List;

@RestController
@RequestMapping("api")
public class SaleController {
  private final CrudService<Sale> service;

  public SaleController(SaleService service) {
    this.service = service;
  }

  @GetMapping("sale")
  @PreAuthorize("isAuthenticated()")
  public List<Sale> getAll() {
    return service.getAll();
  }

  @GetMapping("sale/{id}")
  @PreAuthorize("isAuthenticated()")
  public Sale getOne(@PathVariable("id") Sale sale) {
    return sale;
  }

  @PostMapping("sale")
  @PreAuthorize("isAuthenticated()")
  public Sale saveOne(@RequestBody Sale sale) {
    return service.save(sale);
  }

  @PutMapping("sale/{id}")
  @PreAuthorize("isAuthenticated()")
  public Sale updateOne(@PathVariable("id") Sale saleFromDb, @RequestBody Sale updatedSale) {
    return service.update(updatedSale, saleFromDb);
  }

  @DeleteMapping("sale/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Sale sale) {
    service.delete(sale);
  }
}
