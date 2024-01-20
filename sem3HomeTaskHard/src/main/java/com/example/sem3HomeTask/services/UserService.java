package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Сохранение нового пользователя в БД
     * @param name
     * @param age
     * @param email
     * @return user
     */
    public User createUser(String name, int age, String email) {
        return repository.save(name, age, email);
    }

    /**
     * Получить список всех пользователей
     * @return List<User>
     */
    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
