package spbstu.project.variant_three.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spbstu.project.variant_three.auth.User;
import spbstu.project.variant_three.repository.UserRepository;

import java.util.List;
import java.security.Principal;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @GetMapping
  public User getUser(Principal principal) {
    if (principal == null) {
      return null;
    }

    return userRepository.findByUsername(principal.getName());
  }

  @GetMapping("all")
  @PreAuthorize("hasAnyAuthority('ADMIN')")
  public List<User> getAll() {
    return StreamSupport
        .stream(userRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @PostMapping
  public User addUser(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);
  }
}
