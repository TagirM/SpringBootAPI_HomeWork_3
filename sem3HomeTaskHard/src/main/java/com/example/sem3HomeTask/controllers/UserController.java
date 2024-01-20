package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService service;

    /**
     * Получить список всех пользователей
     * @return  List<User>
     */
    @GetMapping
    public List<User> userList() {
        return service.getAllUsers();
    }

    /**
     * Создание пользователя через body json
     * @param user
     * @return String
     */

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body!";
    }

    /**
     * Создание пользователя через параметры в строке url
     * @param name имя
     * @param age возраст
     * @param email электронная почта
     * @return String
     */
    @PostMapping("/param")
    public String AddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        service.processRegistration(name, age, email);
        return "User added from parameters!";
    }
}
