package spbstu.project.variant_three.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RouteController {
  @GetMapping("/**/{path:[^\\.]*}")
  public String redirect() {
    return "forward:/";
  }
}
