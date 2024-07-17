package com.User.Application.Controller;

import com.User.Application.Entity.User;
import com.User.Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 180)
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/show") //show all users sorted by lastName and dateOfBirth YES
    public List<User> index(){
        return userRepository.showAll();
    }

    @GetMapping("/show/{id}")//search users by ID YES
    public Optional<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @GetMapping("/users/search") // add ?query=an YES
    public ResponseEntity<List<User>> findByName(@RequestParam String query) {
        return ResponseEntity.ok(userRepository.findByName(query));
    }

    @PostMapping("/new-user")//add a new user NO
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable int id, @RequestBody User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = optionalUser.get();

        if (userDetails.getFirstName() != null) {
            existingUser.setFirstName(userDetails.getFirstName());
        }
        if (userDetails.getLastName() != null) {
            existingUser.setLastName(userDetails.getLastName());
        }
        if (userDetails.getDateOfBirth() != null) {
            existingUser.setDateOfBirth(userDetails.getDateOfBirth());
        }
        if (userDetails.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(userDetails.getPhoneNumber());
        }
        if (userDetails.getEmail() != null) {
            existingUser.setEmail(userDetails.getEmail());
        }

        User updatedUser = userRepository.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("delete-user/{id}")// delete an user NO
    public ResponseEntity<Void> delete(@PathVariable int id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
