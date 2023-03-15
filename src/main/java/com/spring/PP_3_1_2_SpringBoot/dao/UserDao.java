package com.spring.PP_3_1_2_SpringBoot.dao;
import com.spring.PP_3_1_2_SpringBoot.model.User;
import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);

    List<User> getAllUsers();

    void userChange(User user, Long id);
}
