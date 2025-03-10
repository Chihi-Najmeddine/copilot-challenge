package sisal.it.copilot.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sisal.it.copilot.challenge.Exception.EntityNotFoundException;
import sisal.it.copilot.challenge.beans.request.Users;
import sisal.it.copilot.challenge.repository.UserRepository;
import sisal.it.copilot.challenge.service.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) throws EntityNotFoundException{
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) throws EntityNotFoundException{
            Users updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws EntityNotFoundException{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
    }
}
