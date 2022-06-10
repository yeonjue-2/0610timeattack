package com.sparta.time0610.controller;

import com.sparta.time0610.domain.User;
import com.sparta.time0610.domain.UserRepository;
import com.sparta.time0610.domain.UserRequestDto;
import com.sparta.time0610.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/api/users")
    public User creatUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/users/{id}")    // PathVariable 주소에 있는 것 사용
    public Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/users/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.update(id, requestDto);
    }

}

