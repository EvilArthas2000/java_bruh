package spbstu.project.variant_three.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.project.variant_three.entity.Good;
import spbstu.project.variant_three.service.GoodService;
import spbstu.project.variant_three.service.CrudService;


import java.util.List;


@RestController
@RequestMapping("api")
public class GoodController {
  private final CrudService<Good> service;

  public GoodController(GoodService service) {
    this.service = service;
  }

  @GetMapping("good")
  @PreAuthorize("isAuthenticated()")
  public List<Good> getAll() {
    return service.getAll();
  }

  @GetMapping("good/{id}")
  @PreAuthorize("isAuthenticated()")
  public Good getOne(@PathVariable("id") Good good) {
    return good;
  }

  @PostMapping("good")
  @PreAuthorize("isAuthenticated()")
  public Good saveOne(@RequestBody Good good) {
    return service.save(good);
  }

  @PutMapping("good/{id}")
  @PreAuthorize("isAuthenticated()")
  public Good updateOne(@PathVariable("id") Good goodFromDb, @RequestBody Good updatedGood) {
    return service.update(updatedGood, goodFromDb);
  }

  @DeleteMapping("good/{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Good good) {
    service.delete(good);
  }
}
