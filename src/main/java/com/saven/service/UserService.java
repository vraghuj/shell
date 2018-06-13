package com.saven.service;
import java.util.List;

import com.saven.model.GapsIndex;
import com.saven.model.User;
public interface UserService {
    List<User> getAllUsers();
    User getUserById(String userName);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String userName);
    List<GapsIndex>	getLatestGaps();
}
 