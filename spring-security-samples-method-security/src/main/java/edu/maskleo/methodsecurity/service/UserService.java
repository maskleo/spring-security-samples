package edu.maskleo.methodsecurity.service;

import edu.maskleo.methodsecurity.domain.User;

import java.util.List;

public interface UserService {

    void removeUser(int id);

    List<User> listUsers();
}
