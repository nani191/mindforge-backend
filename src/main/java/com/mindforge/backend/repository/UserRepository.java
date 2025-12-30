package com.mindforge.backend.repository;
import com.mindforge.backend.domain.User;
import java.util.*;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user){ users.put(user.getEmail(), user); }
    public User findByEmail(String email){ return users.get(email); }
}
