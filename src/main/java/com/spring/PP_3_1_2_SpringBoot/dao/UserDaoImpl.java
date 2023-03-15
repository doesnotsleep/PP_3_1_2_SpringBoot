package com.spring.PP_3_1_2_SpringBoot.dao;


import com.spring.PP_3_1_2_SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    private List<User> users;


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void userChange(User user, Long id) {
        User changeUser = entityManager.find(User.class, id);
        if (changeUser != null) {
            changeUser.setName(user.getName());
            changeUser.setSurname(user.getSurname());
            changeUser.setEmail(user.getEmail());
            entityManager.merge(changeUser);
        }
    }
}
