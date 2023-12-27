package com.example.autoitog.Auth;

import com.example.autoitog.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

//Подключение репозитория CRUD действий
public interface UserRepository extends CrudRepository<UserModel,Long> {
    UserModel findByLogin(String login);
}
