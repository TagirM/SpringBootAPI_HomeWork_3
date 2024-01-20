package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Метод processRegistration
    public void processRegistration (String name, int age, String email){
        User user = userService.createUser(name, age, email);
        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
//        dataProcessingService.addUserToList(user);
    }

    /**
     * Получить список всех пользователей
     * @return
     */
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
