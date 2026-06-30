package com.example.UserService.Controller;

import com.example.UserService.DTO.*;
import com.example.UserService.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserRes register(@Valid @RequestBody RegisterReq req){

        return userService.register(req);
    }
    @GetMapping
    public List<UserRes> getAllUsers(){

        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserRes getUser(@PathVariable Long id){

        return userService.getUserById(id);
    }
    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginReq request){
        System.out.println("LOGIN API HIT");
        return userService.login(request);
    }
    @GetMapping("/profile/{id}")
    public UserProfileResponse getProfile(

            @PathVariable
            Long id) {

        return userService.getProfile(id);

    }
    @PutMapping("/profile/{id}")
    public UserProfileResponse updateProfile(

            @PathVariable
            Long id,

            @RequestBody
            UpdateProfileRequest request) {

        return userService.updateProfile(
                id,
                request
        );

    }
}
