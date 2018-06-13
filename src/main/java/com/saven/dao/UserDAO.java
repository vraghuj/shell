package com.saven.dao;
import java.util.List;

import com.saven.model.GapsIndex;
import com.saven.model.User;
public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(String userName);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String userName);
    boolean userExists(String userName, String mail);
    List<GapsIndex>	getLatestGaps();
}
 