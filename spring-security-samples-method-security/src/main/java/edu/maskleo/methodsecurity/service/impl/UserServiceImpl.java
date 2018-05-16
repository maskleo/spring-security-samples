package edu.maskleo.methodsecurity.service.impl;

import edu.maskleo.methodsecurity.domain.User;
import edu.maskleo.methodsecurity.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {

    private static final Map<Integer, User> USER_REPOSITORY = new ConcurrentHashMap<>();

    public UserServiceImpl() {
        USER_REPOSITORY.put(1, new User(1, "aaa", 10));
        USER_REPOSITORY.put(1, new User(2, "ccc", 21));
        USER_REPOSITORY.put(1, new User(3, "bbb", 0));
        USER_REPOSITORY.put(1, new User(4, "fff", 15));
    }

    @Override
    public void removeUser(int id) {
        USER_REPOSITORY.remove(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(USER_REPOSITORY.values());
    }
}
